package com.se_application.app.modules.classevaluation.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import com.se_application.app.R
import com.se_application.app.appcomponents.base.BaseActivity
import com.se_application.app.databinding.ActivityClassEvaluationBinding
import com.se_application.app.modules.classevaluation.`data`.model.ListphysicalviolenRowModel
import com.se_application.app.modules.classevaluation.`data`.viewmodel.ClassEvaluationVM
import kotlin.Int
import kotlin.String
import kotlin.Unit

class ClassEvaluationActivity :
    BaseActivity<ActivityClassEvaluationBinding>(R.layout.activity_class_evaluation) {
  private val viewModel: ClassEvaluationVM by viewModels<ClassEvaluationVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    val listphysicalviolenAdapter =
    ListphysicalviolenAdapter(viewModel.listphysicalviolenList.value?:mutableListOf())
    binding.recyclerListphysicalviolen.adapter = listphysicalviolenAdapter
    listphysicalviolenAdapter.setOnItemClickListener(
    object : ListphysicalviolenAdapter.OnItemClickListener {
      override fun onItemClick(view:View, position:Int, item : ListphysicalviolenRowModel) {
        onClickRecyclerListphysicalviolen(view, position, item)
      }
    }
    )
    viewModel.listphysicalviolenList.observe(this) {
      listphysicalviolenAdapter.updateData(it)
    }
    binding.classEvaluationVM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.imageArrowleft.setOnClickListener {
      finish()
    }
  }

  fun onClickRecyclerListphysicalviolen(
    view: View,
    position: Int,
    item: ListphysicalviolenRowModel
  ): Unit {
    when(view.id) {
    }
  }

  companion object {
    const val TAG: String = "CLASS_EVALUATION_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, ClassEvaluationActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
