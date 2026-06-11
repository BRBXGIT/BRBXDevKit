package com.brbx.ui_compose.common

// TODO maybe make internal
@RequiresOptIn(
    message = "Using copy directly in Compose without remember can lead " +
            "to unnecessary allocations during recomposition. Use " +
            "rememberCopy instead.",
    level = RequiresOptIn.Level.WARNING,
)
@Retention(AnnotationRetention.BINARY)
@Target(AnnotationTarget.FUNCTION)
annotation class UnsafeAppearanceCopy