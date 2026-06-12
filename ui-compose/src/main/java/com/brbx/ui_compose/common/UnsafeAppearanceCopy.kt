package com.brbx.ui_compose.common

@RequiresOptIn(
    message = "Using copy directly in Compose without remember can lead " +
            "to unnecessary allocations during recomposition. Use " +
            "rememberCopy instead.",
    level = RequiresOptIn.Level.WARNING,
)
@Retention(value = AnnotationRetention.BINARY)
@Target(AnnotationTarget.FUNCTION)
annotation class UnsafeAppearanceCopy