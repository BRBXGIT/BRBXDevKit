package com.brbx.ui_compose.components.with_appearance.annotations

@RequiresOptIn(
    message = "Using copy directly in Compose can lead to unnecessary allocations during recomposition. Use rememberCopy instead.",
    level = RequiresOptIn.Level.WARNING
)
@Retention(AnnotationRetention.BINARY)
@Target(AnnotationTarget.FUNCTION)
annotation class UnsafeAppearanceCopy