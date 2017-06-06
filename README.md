# android-sdk

This is an SDK providing easy way to interact with Userfeeds API.

## Setup

### Request API key

Go to https://api.userfeeds.io/portal/apis/, register and receive key.

### Add dependecy

```
dependencies {
    compile 'io.userfeeds.sdk:core:<latest version here>'
}
```

You may find the latest version number by going to [maven central search](http://search.maven.org/#search|ga|1|g%3A%22io.userfeeds.sdk%22).

### Initialize SDK

You will usually init the SDK in a class extending `Application`.

```
class MyAwesomeApp : Application() {

    override fun onCreate() {
        UserfeedsSdk.initialize(apiKey = "<your API key>")
    }
}
```

## Use

`UserfeedsService.get()` returns an object that contains all the methods corresponding to Userfeeds API endpoints.

Go to [UserfeedsService.kt](https://github.com/Userfeeds/android-sdk/blob/master/core/src/main/java/io/userfeeds/sdk/core/UserfeedsService.kt) for a list of these methods.

# Example

```
class ContextsActivity : AppCompatActivity() {
    
    private lateinit var disposable: Disposable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // ...
        disposable = UserfeedsService.get().getContexts()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::onContexts, this::onError)
    }

    private fun onContexts(contexts: List<ShareContext>) {
        // ...
    }

    private fun onError(error: Throwable) {
        // ...
    }

    override fun onDestroy() {
        super.onDestroy()
        disposable.dispose()
    }
}
```
