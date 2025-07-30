package com.example.pizza_shevtsov_shift_2025.presentation.theme

import androidx.compose.foundation.isSystemInDarkTheme
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect


private val LightColors = lightColorScheme(
    primary            = BrandColorLight,
    onPrimary          = PrimaryTextColorLight,
    secondary          = SecondaryTextColorLight,
    onSecondary        = ButtonColorLight,
    background         = BackgroundColorLight,
    onBackground       = BackgroundColorLight,
    surface            = ButtonColorLight,
    onSurface          = SelectedTabColorLight,
    outline            = IndicatorBorderLineLight
)

private val DarkColors = darkColorScheme(
    primary            = BrandColorDark,
    onPrimary          = PrimaryTextColorDark,
    secondary          = SecondaryTextColorDark,
    onSecondary        = ButtonColorDark,
    background         = BackgroundColorDark,
    onBackground       = OnBackgroundColorDark,
    surface            = ButtonColorDark,
    onSurface          = SelectedTabColorDark,
    outline            = IndicatorBorderLineDark
)

@Composable
fun ShiftPizzaTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) DarkColors else LightColors

    val systemUiController = rememberSystemUiController()
    SideEffect {
        systemUiController.setSystemBarsColor(
            color = colors.primary
        )
    }
    MaterialTheme(
        colorScheme   = colors,
        typography    = Typography,
        shapes        = Shapes,
        content       = content
    )
}