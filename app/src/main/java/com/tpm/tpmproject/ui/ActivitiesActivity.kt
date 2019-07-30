package com.tpm.tpmproject.ui

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import com.tpm.tpmproject.R
import com.tpm.tpmproject.adapter.ActivitiesAdapter
import com.tpm.tpmproject.model.Activities
import kotlinx.android.synthetic.main.activity_activities.*

class ActivitiesActivity : AppCompatActivity() {

    companion object{
        fun newIntent(context: Context):Intent
        {
            var intent = Intent(context,ActivitiesActivity::class.java)
            return intent
        }
    }

    lateinit var activitiesList : List<Activities>
    private val activitiesAdapter : ActivitiesAdapter by lazy { ActivitiesAdapter(activitiesList,this::onClickItem) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_activities)
        activitiesToolbar.setTitle(R.string.activitiesToolbar)
        setSupportActionBar(activitiesToolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        var activity1 = Activities("Sayar U Thein Oo","Don't wait opportunity, Create it!","1.8M","50K","1.8M Seen",R.drawable.chairman,"ACE Data Systems Group ကေနျပီး TALENT Program ကို စတင္လိုက္ျပီ ျဖစ္ပါတယ္… TALENT ဆုိတာ (Training And Learning Environment Nurturing Talent) လို႕ ရည္ညႊန္းပါတယ္… အဲဒါေၾကာင့္ ဒီ Program မွာ IT Professional ျဖစ္ဖို႕လိုုအပ္တဲ့ Intensive Training ေတြ ပညာရွင္ပီပီ အလုပ္လုပ္ကိုင္ဖို႕ လုိအပ္တဲ့ Professional Value ေတြ ေလ့လာ သင္ၾကားနိုင္မယ့္ ပတ္ဝန္းက်င္ေကာင္းေတြနဲ႕အတူ ဆရာေကာင္း Senior ေကာင္းေတြက ပံ့ပိုးသင္ၾကားေပးသြားမွာ ျဖစ္ပါတယ္\n" +
                "ACE Data Systems Group ကေနျပီး TALENT Program ကို စတင္လိုက္ျပီ ျဖစ္ပါတယ္… TALENT ဆုိတာ (Training And Learning Environment Nurturing Talent) လို႕ ရည္ညႊန္းပါတယ္… အဲဒါေၾကာင့္ ဒီ Program မွာ IT Professional ျဖစ္ဖို႕လိုုအပ္တဲ့ Intensive Training ေတြ ပညာရွင္ပီပီ အလုပ္လုပ္ကိုင္ဖို႕ လုိအပ္တဲ့ Professional Value ေတြ ေလ့လာ သင္ၾကားနိုင္မယ့္ ပတ္ဝန္းက်င္ေကာင္းေတြနဲ႕အတူ ဆရာေကာင္း Senior ေကာင္းေတြက ပံ့ပိုးသင္ၾကားေပးသြားမွာ ျဖစ္ပါတယ္")
        var activity2 = Activities("Talent Program Myanmar", "Talent Material are ready now and waiting","50.1K","50K","1M Seen",R.drawable.present,"ACE Data Systems Group ကေနျပီး TALENT Program ကို စတင္လိုက္ျပီ ျဖစ္ပါတယ္… TALENT ဆုိတာ (Training And Learning Environment Nurturing Talent) လို႕ ရည္ညႊန္းပါတယ္… အဲဒါေၾကာင့္ ဒီ Program မွာ IT Professional ျဖစ္ဖို႕လိုုအပ္တဲ့ Intensive Training ေတြ ပညာရွင္ပီပီ အလုပ္လုပ္ကိုင္ဖို႕ လုိအပ္တဲ့ Professional Value ေတြ ေလ့လာ သင္ၾကားနိုင္မယ့္ ပတ္ဝန္းက်င္ေကာင္းေတြနဲ႕အတူ ဆရာေကာင္း Senior ေကာင္းေတြက ပံ့ပိုးသင္ၾကားေပးသြားမွာ ျဖစ္ပါတယ္\n"+
                "ACE Data Systems Group ကေနျပီး TALENT Program ကို စတင္လိုက္ျပီ ျဖစ္ပါတယ္… TALENT ဆုိတာ (Training And Learning Environment Nurturing Talent) လို႕ ရည္ညႊန္းပါတယ္… အဲဒါေၾကာင့္ ဒီ Program မွာ IT Professional ျဖစ္ဖို႕လိုုအပ္တဲ့ Intensive Training ေတြ ပညာရွင္ပီပီ အလုပ္လုပ္ကိုင္ဖို႕ လုိအပ္တဲ့ Professional Value ေတြ ေလ့လာ သင္ၾကားနိုင္မယ့္ ပတ္ဝန္းက်င္ေကာင္းေတြနဲ႕အတူ ဆရာေကာင္း Senior ေကာင္းေတြက ပံ့ပိုးသင္ၾကားေပးသြားမွာ ျဖစ္ပါတယ္")
        activitiesList = mutableListOf(activity1,activity2)

        rcActivities.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = activitiesAdapter
        }

    }
    private fun onClickItem(activity : Activities)
    {
        startActivity(ActivitiesDetailsActivity.newIntent(this,activity.title,activity.bodyText,activity.bgImage))
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == android.R.id.home)
        {
            onBackPressed()
            true
        }
        return super.onOptionsItemSelected(item)
    }
}
