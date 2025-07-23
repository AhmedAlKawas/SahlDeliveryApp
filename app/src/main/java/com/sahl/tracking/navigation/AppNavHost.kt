package com.sahl.tracking.navigation

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.sahl.tracking.model.AppConstants.NAV_TRANSITION_DURATION
import com.sahl.tracking.ui.screens.order_details.OrderDetailsScreen
import com.sahl.tracking.ui.screens.orders_screen.OrdersScreen

@Composable
fun AppNavHost(
    navController: NavHostController
) {

    NavHost(
        navController = navController,
        startDestination = OrdersScreenRoute,
        enterTransition = {
            slideIntoContainer(
                towards = AnimatedContentTransitionScope.SlideDirection.Start,
                animationSpec = tween(NAV_TRANSITION_DURATION)
            )
        },
        exitTransition = {
            slideOutOfContainer(
                towards = AnimatedContentTransitionScope.SlideDirection.Start,
                animationSpec = tween(NAV_TRANSITION_DURATION)
            )
        },
        popEnterTransition = {
            slideIntoContainer(
                towards = AnimatedContentTransitionScope.SlideDirection.End,
                animationSpec = tween(NAV_TRANSITION_DURATION)
            )
        },
        popExitTransition = {
            slideOutOfContainer(
                towards = AnimatedContentTransitionScope.SlideDirection.End,
                animationSpec = tween(NAV_TRANSITION_DURATION)
            )
        }
    ) {

        composable<OrdersScreenRoute> {
            OrdersScreen(onOrderItemClick = {
                navController.navigate(
                    OrderDetailsScreenRoute(
                        orderId = it.id,
                        restaurant = it.restaurant
                    )
                )
            })
        }

        composable<OrderDetailsScreenRoute> { backStackEntry ->

            val route = backStackEntry.toRoute<OrderDetailsScreenRoute>()

            OrderDetailsScreen(
                orderId = route.orderId,
                restaurant = route.restaurant
            )
        }

    }
}