# Progress View


## What Works

##### Implementation of the fragment with the ability to display indeterminate progress indicator when you are waiting for the initial data.

##### Tutorial
#[Youtube](https://youtu.be/eJAhw76pThg "Youtube")

### How to Import
##### Step 1. Add the JitPack repository to your build file
```java
allprojects {
    repositories {
        maven { url 'https://jitpack.io' }
    }
}
```

##### Step 2. Add the dependency
```java
dependencies {
    implementation 'com.github.iamkurtgoz:ProgressView:1.2'
}
```
[![](https://jitpack.io/v/iamkurtgoz/ProgressView.svg)](https://jitpack.io/#iamkurtgoz/ProgressView)

## What Works
```java
public abstract class BaseFragment extends BaseProgressFragment {
```
* Extend your fragment from the library *

### After 

```java
setLoading(); //for loading
setLoading("Loading.. Please Wait"); //for loading

setTextMessage("Error connection. Please try again later."); //just text message

setMessage(R.drawable.error_image,"Error Data","Please try again later."); //rich message
```
# CONTACT : kurtgozmehmet159@gmail.com
