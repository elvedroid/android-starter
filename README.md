# android-starter

This is Dagger starter Android Applicatin. I named it MVP-Dagger, but the only thing that is connected to MVP is the BaseContract interface. The difference between this app and the base starter app is that instead of ServiceFactory, the dependencies are provider by Dagger. This is the **Kotlin** version. This application includes:

## Libraries

* Android X (appcompat, legacy-support-v4, cardview, constraintlayout)
* Multidex
* Retrofit
* Dagger 2
* RxJava
* Glide
* Test Libraries (junit, runner, espresso-core)

## Utils

* DeviceUtil (showSoftKeyboard, hideSoftKeyboard)
* Constant object class
* Gson and OkHttpClient Utils
* Extensions:

        ImageView.loadImage(image: Any)