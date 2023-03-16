package com.se_application.app.modules.parentviewone.ui

import android.view.View
import androidx.activity.viewModels
import com.se_application.app.R
import com.se_application.app.appcomponents.base.BaseActivity
import com.se_application.app.databinding.ActivityParentViewOneBinding
import com.se_application.app.modules.parentviewfour.ui.ParentViewFourActivity
import com.se_application.app.modules.parentviewone.`data`.model.ListnoRowModel
import com.se_application.app.modules.parentviewone.`data`.viewmodel.ParentViewOneVM
import com.se_application.app.modules.parentviewtwo.ui.ParentViewTwoActivity
import kotlin.Int
import kotlin.String
import kotlin.Unit

class ParentViewOneActivity :
    BaseActivity<ActivityParentViewOneBinding>(R.layout.activity_parent_view_one) {
  private val viewModel: ParentViewOneVM by viewModels<ParentViewOneVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    val listnoAdapter = ListnoAdapter(viewModel.listnoList.value?:mutableListOf())
    binding.recyclerListno.adapter = listnoAdapter
    listnoAdapter.setOnItemClickListener(
    object : ListnoAdapter.OnItemClickListener {
      override fun onItemClick(view:View, position:Int, item : ListnoRowModel) {
        onClickRecyclerListno(view, position, item)
      }
    }
    )
    viewModel.listnoList.observe(this) {
      listnoAdapter.updateData(it)
    }
    binding.parentViewOneVM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.txtJoeJamesOne.setOnClickListener {
      val destIntent = ParentViewTwoActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.linearRowcontactsupervi.setOnClickListener {
      val destIntent = ParentViewFourActivity.getIntent(this, null)
      startActivity(destIntent)
    }
  }

  fun onClickRecyclerListno(
    view: View,
    position: Int,
    item: ListnoRowModel
  ): Unit {
    when(view.id) {
    }
  }

  companion object {
    const val TAG: String = "PARENT_VIEW_ONE_ACTIVITY"

  }
}
