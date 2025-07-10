package com.example.pizza_shevtsov_shift_2025

import android.annotation.SuppressLint
import androidx.compose.animation.AnimatedContentScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.material3.Text
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.pizza_shevtsov_shift_2025.presentation.screens.catalog.CatalogRoute
import com.example.pizza_shevtsov_shift_2025.presentation.screens.pizza.PizzaRoute
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.example.pizza_shevtsov_shift_2025.presentation.navigation.NavigationOption
import com.example.pizza_shevtsov_shift_2025.presentation.screens.cart.CartRoute
import com.example.pizza_shevtsov_shift_2025.presentation.screens.cart.CartScreen
import com.example.pizza_shevtsov_shift_2025.presentation.screens.catalog.CatalogScreen
import com.example.pizza_shevtsov_shift_2025.presentation.screens.order.OrderRoute
import com.example.pizza_shevtsov_shift_2025.presentation.screens.order.OrderScreen
import com.example.pizza_shevtsov_shift_2025.presentation.screens.pizza.PizzaScreen
import com.example.pizza_shevtsov_shift_2025.presentation.screens.profile.ProfileRoute
import com.example.pizza_shevtsov_shift_2025.presentation.screens.profile.ProfileScreen

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreen() {
    val navController = rememberNavController()
    val selectedTab = rememberSaveable { mutableStateOf(NavigationOption.PIZZA) }

    Scaffold { paddingValues: PaddingValues ->
        Column(modifier = Modifier.padding(top = paddingValues.calculateTopPadding())) {

            NavHost(
                modifier = Modifier
                    .padding(paddingValues)
                    .weight(1f),
                navController = navController,
                startDestination = CatalogRoute,
            ) {
                composable<CatalogRoute> {
                    CatalogScreen(
                        onItemClick = { pizzaId ->
                            navController.navigate(PizzaRoute(pizzaId))
                        }
                    )
                }
                composable<PizzaRoute> { it: NavBackStackEntry ->
                    val destination = it.toRoute<PizzaRoute>()

                    PizzaScreen(
                        pizzaId = destination.pizzaId,
                        onBackClick = {
                            navController.navigateUp()
                        }
                    )
                }
                composable<OrderRoute> {
                    OrderScreen()
                }
                composable<CartRoute> {
                    CartScreen()
                }
                composable<ProfileRoute> {
                    ProfileScreen()
                }

            }
            BottomNavigation(
                navigationOptions = NavigationOption.entries,
                selectedNavigationOption = selectedTab.value,
                onItemClicked = { navOption ->
                    when (navOption) {
                        NavigationOption.PIZZA -> navController.openPoppingAllPrevious(CatalogRoute)
                        NavigationOption.ORDER -> navController.openPoppingAllPrevious(OrderRoute)
                        NavigationOption.CART -> navController.openPoppingAllPrevious(CartRoute)
                        NavigationOption.PROFILE -> navController.openPoppingAllPrevious(ProfileRoute)
                    }
                    selectedTab.value = navOption
                }
            )
        }
    }
}

inline fun <reified T : Any> NavGraphBuilder.animatedComposable(noinline block: @Composable AnimatedContentScope.(NavBackStackEntry) -> Unit) {
    composable<T>(
        enterTransition = ENTER_TRANSITION,
        exitTransition = EXIT_TRANSITION,
        popEnterTransition = POP_ENTER_TRANSITION,
        popExitTransition = POP_EXIT_TRANSITION,
        content = block
    )
}

@Composable
private fun BottomNavigation(
    navigationOptions: List<NavigationOption>,
    selectedNavigationOption: NavigationOption,
    onItemClicked: (NavigationOption) -> Unit,
) {
  NavigationBar{
      for (option in navigationOptions){
          NavigationBarItem(
              selected = selectedNavigationOption == option,
              onClick = {onItemClicked(option)},
              icon = { Icon(getIcon(option), "") },
              label = { Text(text = getLabel(option))}
          )
      }
  }
}

private fun getIcon(option: NavigationOption): ImageVector =
    when (option){
        NavigationOption.PIZZA -> Icons.Default.Home
        NavigationOption.ORDER -> Icons.Default.Favorite
        NavigationOption.CART -> Icons.Default.Delete
        NavigationOption.PROFILE -> Icons.Default.Settings
    }

@Composable
private fun getLabel(option: NavigationOption): String = stringResource(
    when (option){
        NavigationOption.PIZZA -> R.string.bottom_bar_pizza
        NavigationOption.ORDER -> R.string.bottom_bar_order
        NavigationOption.CART -> R.string.bottom_bar_cart
        NavigationOption.PROFILE -> R.string.bottom_bar_profile
    }
)

fun NavController.openPoppingAllPrevious(route: Any) {
    this.navigate(route) {
        popUpTo(graph.startDestinationId)
        launchSingleTop = true
    }
}