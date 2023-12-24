package com.feature.movie_detail.ui.navigation

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.core.common.navigation_constants.MovieDetailFeature
import com.core.feature_api.FeatureApi
import com.feature.movie_detail.ui.screen.MovieDetailScreen
import com.feature.movie_detail.ui.screen.MovieDetailViewModel

internal object InternalMovieDetailApi : FeatureApi {
    override fun registerGraph(navController: NavHostController, navGraphBuilder: NavGraphBuilder) {
        navGraphBuilder.navigation(
            route = MovieDetailFeature.movieDetailScreenRoute,
            startDestination = MovieDetailFeature.nestedRoute
        ) {
            composable(route = MovieDetailFeature.nestedRoute) {
                val id = it.arguments?.getString("id")
                val viewModel: MovieDetailViewModel = hiltViewModel()
                MovieDetailScreen(id = id.toString(), viewModel = viewModel)
            }
        }
    }
}