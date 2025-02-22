package com.flipperdevices.keyemulate.composable.common

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.flipperdevices.core.ui.ktx.image.Picture
import com.flipperdevices.core.ui.theme.LocalPallet
import com.flipperdevices.core.ui.theme.LocalTypography
import com.flipperdevices.keyemulate.composable.common.button.ComposableEmulateButton
import com.flipperdevices.keyemulate.model.EmulateProgress

@Composable
internal fun InternalComposableEmulateButtonWithText(
    buttonText: String,
    color: Color,
    modifier: Modifier = Modifier,
    buttonModifier: Modifier = Modifier,
    progress: EmulateProgress? = null,
    @StringRes textId: Int? = null,
    @DrawableRes iconId: Int? = null,
    picture: Picture? = null,
    progressColor: Color = Color.Transparent
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ComposableEmulateButton(
            buttonContentModifier = buttonModifier,
            emulateProgress = progress,
            text = buttonText,
            picture = picture,
            color = color,
            progressColor = progressColor
        )

        Row(verticalAlignment = Alignment.CenterVertically) {
            if (iconId != null) {
                Icon(
                    modifier = Modifier
                        .padding(horizontal = 4.dp)
                        .size(14.dp),
                    painter = painterResource(iconId),
                    contentDescription = textId?.let { stringResource(it) }.orEmpty(),
                    tint = LocalPallet.current.warningColor
                )
            }
            if (textId != null) {
                Text(
                    text = stringResource(textId),
                    style = LocalTypography.current.bodyR14.copy(fontSize = 12.sp),
                    color = LocalPallet.current.text30
                )
            }
        }
    }
}

@Composable
internal fun InternalComposableEmulateButtonWithText(
    @StringRes buttonTextId: Int,
    color: Color,
    modifier: Modifier = Modifier,
    buttonModifier: Modifier = Modifier,
    progress: EmulateProgress? = null,
    @StringRes textId: Int? = null,
    @DrawableRes iconId: Int? = null,
    picture: Picture? = null,
    progressColor: Color = Color.Transparent
) {
    InternalComposableEmulateButtonWithText(
        buttonText = stringResource(buttonTextId),
        color = color,
        modifier = modifier,
        buttonModifier = buttonModifier,
        progress = progress,
        textId = textId,
        iconId = iconId,
        picture = picture,
        progressColor = progressColor
    )
}
