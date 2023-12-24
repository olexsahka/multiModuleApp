package com.feature.movie_detail.ui.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import com.core.feature_api.FeatureApi

interface MovieDetailApi: FeatureApi{
    class BaseMovieDetailApiImpl(): MovieDetailApi {
        override fun registerGraph(
            navController: NavHostController,
            navGraphBuilder: NavGraphBuilder
        ) {
            InternalMovieDetailApi.registerGraph(navController,navGraphBuilder)
        }
    }
}
