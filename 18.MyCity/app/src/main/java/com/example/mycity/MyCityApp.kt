package com.example.mycity

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.mycity.data.LocalCategoriesDataProvider
import com.example.mycity.data.LocalPlacesDataProvider
import com.example.mycity.model.Category
import com.example.mycity.ui.CategoryScreen
import com.example.mycity.ui.MyCityScreen
import com.example.mycity.ui.PlaceScreen
import com.example.mycity.ui.ScreenId
import com.example.mycity.ui.component.TopBar

@Composable
fun MyCityApp(
    navController: NavHostController = rememberNavController(),
    modifier: Modifier = Modifier
) {

    val backStackEntry by navController.currentBackStackEntryAsState()
//    val currentScreen = ScreenId.valueOf(backStackEntry?.destination?.route ?: ScreenId.MyCity.name)
    val currentScreen = backStackEntry?.destination?.route ?: ScreenId.MyCity.name
//    val viewModel: OrderViewModel = viewModel()

    Scaffold(
        topBar = {
            TopBar(
                currentScreen = currentScreen,
                canNavigateBack = navController.previousBackStackEntry != null,
                navigateUp = { navController.navigateUp() }
            )
        }
    ) { innerPadding ->
//        val uiState by viewModel.uiState.collectAsState()

        NavHost(
            navController = navController,
            startDestination = ScreenId.MyCity.name,
            modifier = Modifier
                .fillMaxSize()
//                .verticalScroll(rememberScrollState())
                .padding(innerPadding)
        ) {
            composable(route = ScreenId.MyCity.name) {
                MyCityScreen(
                    categories = LocalCategoriesDataProvider.getCategoriesData(),
                    onClick = { category ->
                        navController.navigate("${ScreenId.Category.name}/${category.id}")
                    },
                    modifier = Modifier
//                        .padding(16.dp)
                        .fillMaxSize()
                )
            }
            composable(
                route = "${ScreenId.Category.name}/{categoryId}",
                arguments = listOf(
                    navArgument(name = "categoryId") { type = NavType.IntType}
                )
            ) { navBackStackEntry ->
                val categoryId = navBackStackEntry.arguments?.getInt("categoryId")
                CategoryScreen(
                    places = LocalPlacesDataProvider.getPlacesData(categoryId ?: 1),
                    onClick = { place ->
                        navController.navigate("${ScreenId.Place.name}/${place.id}")
                    },
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxSize()
                )
            }
            composable(
                route = "${ScreenId.Place.name}/{placeId}",
                arguments = listOf(
                    navArgument(name = "placeId") { type = NavType.IntType}
                )
            ) {
                PlaceScreen(
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxSize()
                )
            }
//            composable(route = ScreenId.MyCity.name) {
//                StartOrderScreen(
//                    onStartOrderButtonClicked = {
//                        navController.navigate(LunchTrayScreen.Entree.name)
//                    },
//                    modifier = Modifier
//                        .padding(dimensionResource(R.dimen.padding_medium))
//                        .fillMaxSize()
//                )
//            }
//            composable(route = LunchTrayScreen.Entree.name) {
//                EntreeMenuScreen(
//                    options = DataSource.entreeMenuItems,
//                    onCancelButtonClicked = {
//                        cancelOrderAndNavigateToStart(viewModel = viewModel, navController = navController)
//                    },
//                    onNextButtonClicked = {
//                        navController.navigate(LunchTrayScreen.SideDish.name)
//                    },
//                    onSelectionChanged = {},
//                    modifier = Modifier
//                        .padding(dimensionResource(R.dimen.padding_medium))
//                        .verticalScroll(rememberScrollState())
//                )
//            }
//            composable(route = LunchTrayScreen.SideDish.name) {
//                SideDishMenuScreen(
//                    options = DataSource.sideDishMenuItems,
//                    onNextButtonClicked = {
//                        navController.navigate(LunchTrayScreen.Accompaniment.name)
//                    },
//                    onCancelButtonClicked = {
//                        cancelOrderAndNavigateToStart(viewModel = viewModel, navController = navController)
//                    },
//                    onSelectionChanged = {},
//                    modifier = Modifier
//                        .padding(dimensionResource(R.dimen.padding_medium))
//                        .verticalScroll(rememberScrollState())
//                )
//            }
//            composable(route = LunchTrayScreen.Accompaniment.name) {
//                AccompanimentMenuScreen(
//                    options = DataSource.accompanimentMenuItems,
//                    onCancelButtonClicked = {
//                        cancelOrderAndNavigateToStart(viewModel = viewModel, navController = navController)
//                    },
//                    onNextButtonClicked = {
//                        navController.navigate(LunchTrayScreen.Checkout.name)
//                    },
//                    onSelectionChanged = {},
//                    modifier = Modifier
//                        .padding(dimensionResource(R.dimen.padding_medium))
//                        .verticalScroll(rememberScrollState())
//                )
//            }
//            composable(route = LunchTrayScreen.Checkout.name) {
//                CheckoutScreen(
//                    orderUiState = OrderUiState(
//                        entree = DataSource.entreeMenuItems[0],
//                        sideDish = DataSource.sideDishMenuItems[0],
//                        accompaniment = DataSource.accompanimentMenuItems[0],
//                        itemTotalPrice = 15.00,
//                        orderTax = 1.00,
//                        orderTotalPrice = 16.00
//                    ),
//                    onNextButtonClicked = {
//                        navController.navigate(LunchTrayScreen.Start.name)
//                    },
//                    onCancelButtonClicked = {
//                        cancelOrderAndNavigateToStart(viewModel = viewModel, navController = navController)
//                    },
//                    modifier = Modifier
//                        .padding(dimensionResource(R.dimen.padding_medium))
//                        .verticalScroll(rememberScrollState())
//                )
//            }
        }
    }

}

@Preview
@Composable
private fun MyCityAppPreview() {
    MyCityApp()
}