package com.excample.kitsu.data.remote.pagingsources

import android.net.Uri
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.bumptech.glide.load.HttpException
import com.excample.kitsu.data.models.manga.MangaItem
import com.excample.kitsu.data.remote.apiservices.MangaApiService
import java.io.IOException


const val DEFAULT_LIMIT_NUMBER = 1

class MangaPagingResource constructor(private val service: MangaApiService) :
    PagingSource<Int, MangaItem>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, MangaItem> {
        try {
            val page = params.key ?: DEFAULT_LIMIT_NUMBER

            val response = service.fetchManga(params.loadSize, page)
            val nextPageNumber = if (response.links.next == null) {
                null
            } else {
                Uri.parse(response.links.next).getQueryParameter("page[offset]")!!.toInt()
            }

            return LoadResult.Page(
                data = response.data,
                prevKey = null, // Only paging forward.
                nextKey = nextPageNumber
            )

        } catch (e: IOException) {
            return LoadResult.Error(e)
        } catch (e: HttpException) {
            return LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, MangaItem>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }
}