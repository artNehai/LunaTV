package com.github.artnehay.lunatv.domain.model

import androidx.annotation.StringRes
import com.github.artnehay.lunatv.R

enum class Section(
    @StringRes val titleId: Int,
) {
    PopularTomorrow(R.string.section_popular_tomorrow),
    PopularToday(R.string.section_popular_today),
    PopularYesterday(R.string.section_popular_yesterday),
}