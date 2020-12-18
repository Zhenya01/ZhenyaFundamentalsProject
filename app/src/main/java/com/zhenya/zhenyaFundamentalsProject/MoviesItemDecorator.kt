package com.zhenya.zhenyaFundamentalsProject

import android.content.res.Resources
import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class MoviesItemDecorator(resources: Resources) : RecyclerView.ItemDecoration() {
    val margin = resources.getDimension(R.dimen.margin_11).toInt()
    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
        if (parent.getChildAdapterPosition(view) % 2 != 0) {
            outRect.right = 0
            outRect.left = margin / 2
        } else {
            outRect.right = margin / 2
            outRect.left = 0
        }

        outRect.top = 0
        outRect.bottom = margin

    }
}
