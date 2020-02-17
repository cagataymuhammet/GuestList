# [Simple Guest List ( MVVM & Kotlin & Dagger2 )](https://github.com/cagataymuhammet/GuestList)

[![kotlin](https://img.shields.io/badge/Kotlin-1.3.xxx-brightgreen.svg)](https://kotlinlang.org/) [![Dagger 2](https://img.shields.io/badge/Dagger-2.xx-orange.svg)](https://google.github.io/dagger/) [![Kotlin-Android-Extensions](https://img.shields.io/badge/Kotlin--Android--Extensions-plugin-red.svg)](https://kotlinlang.org/docs/tutorials/android-plugin.html) [![MVVM](https://img.shields.io/badge/Clean--Code-MVVM-brightgreen.svg)](https://github.com/googlesamples/android-architecture) [![Codacy Badge](https://api.codacy.com/project/badge/Grade/96a9f51de7eb4a00841953d51c48b968)](https://www.codacy.com/manual/cagataymuhammet/GuestList?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=cagataymuhammet/GuestList&amp;utm_campaign=Badge_Grade) <a><img src="https://img.shields.io/badge/API-21%2B-brightgreen.svg?style=flat" alt="API" /></a>
  
  
<p align="center">
<img src="https://github.com/cagataymuhammet/GuestList/blob/master/images/android_arc.png"/>
</p>


# GuestList App
![appicon](https://github.com/cagataymuhammet/GuestList/blob/master/images/guest_list_app.png)

GuestList is a simple Event and Guest Lister app, which uses Boomset APIs t

The main goal of this app is to be a sample of how to build an high quality Android application that uses the Architecture components, Dagger etc. in Kotlin.

<h2 id="Outputs">Outputs</h2>
<p>
  <img height= "500"  src="https://github.com/cagataymuhammet/GuestList/blob/master/images/ss1.png" alt="SS1" /> 
  <img height= "500"  src="https://github.com/cagataymuhammet/GuestList/blob/master/images/ss2.png" alt="SS2" /> 
  <img height= "500"  src="https://github.com/cagataymuhammet/GuestList/blob/master/images/ss3.png" alt="SS3" /> 
  <img height= "500"  src="https://github.com/cagataymuhammet/GuestList/blob/master/images/ss4.png" alt="SS3" />

</p>

## Architecture
The app uses MVVM [Model-View-ViewModel] architecture to have a unidirectional flow of data, separation of concern, testability, and a lot more.

![Architecture](https://developer.android.com/topic/libraries/architecture/images/final-architecture.png)

# What is MVVM?
Model-View-ViewModel (ie MVVM) is a template of a client application architecture, proposed by John Gossman as an alternative to MVC and MVP patterns when using Data Binding technology. Its concept is to separate data presentation logic from business logic by moving it into particular class for a clear distinction.  

## Clean Simple Architecture
![Architecture](https://github.com/cagataymuhammet/GuestList/blob/master/images/clean_arch.png)

## Libraries and tools 🛠
<li><a href="https://developer.android.com/topic/libraries/architecture/viewmodel">ViewModel</a></li>
<li><a href="https://developer.android.com/topic/libraries/architecture/livedata">LiveData</a></li>
<li><a href="https://developer.android.com/topic/libraries/data-binding">Data Binding</a></li>
<li><a href="https://developer.android.com/topic/libraries/architecture/room">RoomDB</a></li>
<li><a href="https://github.com/ReactiveX/RxJava">RxJava</a></li>
<li><a href="https://github.com/ReactiveX/RxAndroid">RxAndroid</a></li>
<li><a href="https://github.com/ReactiveX/RxKotlin">RxKotlin</a></li>
<li><a href="https://github.com/google/dagger">Dagger 2</a></li>
<li><a href="https://square.github.io/retrofit/">Retrofit</a></li>
<li><a href="https://github.com/square/okhttp">OkHttp</a></li>
<li><a href="https://material.io/develop/android/docs/getting-started/">Material Design</a></li>


License
--------


    Copyright 2020 Muhammet ÇAĞATAY.

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
