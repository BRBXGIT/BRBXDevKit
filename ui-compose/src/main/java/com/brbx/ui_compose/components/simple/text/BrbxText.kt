package com.brbx.ui_compose.components.simple.text

import androidx.compose.foundation.text.TextAutoSize
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextLayoutResult
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.max
import androidx.compose.ui.unit.min
import com.brbx.core.common.BrbxText

/**
 * A highly versatile text component that wraps the standard Jetpack Compose [Text].
 * * This component simplifies text handling across the design system by accepting a [BrbxText]
 * parameter, which seamlessly resolves either raw string data ([BrbxText.Raw]) or Android
 * string resources ([BrbxText.Res]) automatically. It passes all standard styling and layout
 * parameters down to the underlying [Text] composable.
 *
 * @param text The [BrbxText] to be displayed. Can be a raw string or a string resource ID.
 * @param modifier The [Modifier] applied to this text component.
 * @param color The [Color] to apply to the text. If [Color.Unspecified], the color from the [style] will be used.
 * @param autoSize Optional [TextAutoSize] configuration to dynamically adjust the text size to fit its bounds.
 * @param fontSize The size of glyphs to use when painting the text.
 * @param fontStyle The typeface variant to use when drawing the letters (e.g., italic).
 * @param fontWeight The typeface thickness to use when painting the text (e.g., bold).
 * @param fontFamily The font family to be used when rendering the text.
 * @param letterSpacing The amount of space to add between each letter.
 * @param textDecoration The decorations to paint on the text (e.g., an underline).
 * @param textAlign The alignment of the text within the lines of the paragraph.
 * @param lineHeight Line height for the [Paragraph] in [TextUnit] unit, e.g. SP or EM.
 * @param overflow How visual overflow should be handled (e.g., clipping or ellipsis).
 * @param softWrap Whether the text should break at soft line breaks. If false, the glyphs will be positioned as if there was unlimited horizontal space.
 * @param maxLines An optional maximum number of lines for the text to span, wrapping if necessary.
 * @param minLines The minimum height in terms of minimum number of visible lines.
 * @param onTextLayout Callback that is executed when a new text layout is calculated. A [TextLayoutResult] object that callback provides contains paragraph information, size of the text, baselines and other details.
 * @param style Style configuration for the text such as color, font, line height etc. Defaults to [LocalTextStyle.current].
 */
@Composable
fun BrbxText(
    text: BrbxText,
    modifier: Modifier = Modifier,
    color: Color = Color.Unspecified,
    autoSize: TextAutoSize? = null,
    fontSize: TextUnit = TextUnit.Unspecified,
    fontStyle: FontStyle? = null,
    fontWeight: FontWeight? = null,
    fontFamily: FontFamily? = null,
    letterSpacing: TextUnit = TextUnit.Unspecified,
    textDecoration: TextDecoration? = null,
    textAlign: TextAlign? = null,
    lineHeight: TextUnit = TextUnit.Unspecified,
    overflow: TextOverflow = TextOverflow.Clip,
    softWrap: Boolean = true,
    maxLines: Int = Int.MAX_VALUE,
    minLines: Int = 1,
    onTextLayout: ((TextLayoutResult) -> Unit)? = null,
    style: TextStyle = LocalTextStyle.current,
) {
    val actualText = when (text) {
        is BrbxText.Raw -> text.text
        is BrbxText.Res -> stringResource(text.resId)
    }
    Text(
        text = actualText,
        color = color,
        modifier = modifier,
        autoSize = autoSize,
        fontSize = fontSize,
        fontStyle = fontStyle,
        fontWeight = fontWeight,
        fontFamily = fontFamily,
        letterSpacing = letterSpacing,
        textDecoration = textDecoration,
        textAlign = textAlign,
        lineHeight = lineHeight,
        overflow = overflow,
        softWrap = softWrap,
        maxLines = maxLines,
        minLines = minLines,
        onTextLayout = onTextLayout,
        style = style,
    )
}