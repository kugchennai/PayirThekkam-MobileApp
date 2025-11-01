package com.kug.payirthekkam.app

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.kug.payirthekkam.feature.ui.FeatureScreen
import com.kug.payirthekkam.findstorage.ui.FindStorageScreen
import com.kug.payirthekkam.feature.ui.my_storage.MyStorageScreen
import com.kug.payirthekkam.feature.ui.LoginScreen
import com.kug.payirthekkam.home.HomeScreen
import org.jetbrains.compose.resources.StringResource
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import payirthekkam.composeapp.generated.resources.Res
import payirthekkam.composeapp.generated.resources.arrow_back
import payirthekkam.composeapp.generated.resources.back_button
import payirthekkam.composeapp.generated.resources.feature
import payirthekkam.composeapp.generated.resources.home
import payirthekkam.composeapp.generated.resources.login
import payirthekkam.composeapp.generated.resources.my_storage

/**
 * enum values that represent the screens in the app
 */
enum class Screen(val title: StringResource) {
    Login(title = Res.string.login),
    Home(title = Res.string.home),
    Feature(title = Res.string.feature),
    FindStorage(title = Res.string.feature),
    MyStorage(title = Res.string.my_storage)
}

/**
 * Composable that displays the topBar and displays back button if back navigation is possible.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PayirThekkamAppBar(
    currentScreen: Screen,
    canNavigateBack: Boolean,
    navigateUp: () -> Unit,
    modifier: Modifier = Modifier
) {
    TopAppBar(
        title = { Text(stringResource(currentScreen.title)) },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color.White
        ),
        modifier = modifier,
        navigationIcon = {
            if (canNavigateBack) {
                IconButton(onClick = navigateUp) {
                    Icon(
                        painter = painterResource(Res.drawable.arrow_back),
                        contentDescription = stringResource(Res.string.back_button)
                    )
                }
            }
        }
    )
}

@Composable
fun PayirThekkamApp(
    viewModel: PayirThekkamViewModel = viewModel { PayirThekkamViewModel() },
    navController: NavHostController = rememberNavController()
) {
    // Get current back stack entry
    val backStackEntry by navController.currentBackStackEntryAsState()
    // Get the name of the current screen
    val currentScreen = Screen.valueOf(
        backStackEntry?.destination?.route ?: Screen.Home.name
    )

    Scaffold(
        topBar = {
            if (currentScreen.name != Screen.Home.name) {
                PayirThekkamAppBar(
                    currentScreen = currentScreen,
                    canNavigateBack = navController.previousBackStackEntry != null,
                    navigateUp = { navController.navigateUp() }
                )
            }
        }
    ) { innerPadding ->
        val uiState by viewModel.uiState.collectAsStateWithLifecycle()

        NavHost(
            navController = navController,
            startDestination = Screen.Login.name,
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(innerPadding)
        ) {
            composable(route = Screen.Login.name) {
                LoginScreen()
            }
            composable(route = Screen.Home.name) {
                HomeScreen(
                    onFindStorageClicked = {
                        navController.navigate(Screen.FindStorage.name)
                    },
                    onMyStorageClicked = {
                        navController.navigate(Screen.MyStorage.name)
                    }
                )
            }

            composable(Screen.Feature.name) {
                FeatureScreen()
            }

            composable(Screen.FindStorage.name) {
                FindStorageScreen()
            }

            composable(
                route = Screen.MyStorage.name
            ) {
                MyStorageScreen()
            }
        }
    }
}

/**
 * Resets the [PayitThekkamViewModel] and pops up to [Screen.Home]
 */
//private fun cancelAndNavigateToStart(
//    viewModel: PayirThekkamViewModel,
//    navController: NavHostController
//) {
//    viewModel.resetState()
//    navController.popBackStack(CupcakeScreen.Start.name, inclusive = false)
//}
