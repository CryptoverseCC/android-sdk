package io.userfeeds.sdk.ui.context

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import io.reactivex.android.schedulers.AndroidSchedulers
import io.userfeeds.sdk.core.UserfeedsService
import io.userfeeds.sdk.core.context.ShareContext
import io.userfeeds.sdk.ui.R
import kotlinx.android.synthetic.main.userfeeds_contexts_activity.*

class ContextsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.userfeeds_contexts_activity)
        setSupportActionBar(userfeeds_toolbar)
        UserfeedsService.get().getContexts()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::onContexts, this::onError)
    }

    private fun onContexts(contexts: List<ShareContext>) {
        userfeeds_context_list.layoutManager = LinearLayoutManager(this)
        userfeeds_context_list.adapter = ContextListAdapter(contexts) {

        }
    }

    private fun onError(error: Throwable) {
        Log.e("ContextsActivity", "error", error)
    }
}
