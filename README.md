# Traveller
<img src="https://user-images.githubusercontent.com/36377165/183493012-64e6e623-bb56-4e2e-94e6-87ec6c9506a6.gif" width="300">

Traveller Android App [Work in progress 🚧]
==================

Traveller is a demo Android for travels and hotel reservation (inspired
by [this design](https://www.figma.com/file/cgIe4WYf01DECbulxPIGMZ/Travel-App-Design-(Community))).
This app built entirely with Kotlin and amazing Jetpack Compose. It follows Android design and
development best practices and is intended to be a portfolio app for me as middle android developer.

The app is currently in early stage development and is not yet available on the Play Store.

# Tech stack

This application built with modern Android and Kotlin technologies:

- Entire UI built with Jetpack Compose (in combination with
  the [Accompanist library](https://google.github.io/accompanist/))
- Kotlin Coroutines for async work
- Hilt for dependency injection
- Navigation built via Jetpack Compose Navigation
- Clean architecture and MVVM pattern for presentation layer
- Gradle KTS and libs catalog 🔥
- Firebase features ([Firebase Auth](https://firebase.google.com/docs/auth?authuser=0)
  , [Firebase Cloud Firestore](https://firebase.google.com/docs/firestore?authuser=0))

Technologies that haven't yet been implemented:
- Modularization
- Unit (using Hilt) and UI tests
- Firebase crashlytics and CI
- Support of dark theme (for now app support only light theme because I'm lack of colors for dark
  theme 😔)

# Features

The primary features of the application will be:
- Authentication flow
- Home screen with popular travel programs and popular destinations
- List of available hotels and booking flow
- User profile page and settings

The minor features will be:
- Error message, that internet connection is lost

# Authentication flow

## Screenshots

<img src="https://user-images.githubusercontent.com/36377165/183498518-b0a92b59-e622-4077-80d5-e3c0d2ee3af1.png" width="300"> <img src="https://user-images.githubusercontent.com/36377165/183498608-41fe505d-7fe1-4f81-9831-78ea858e77b7.png" width="300">
<img src="https://user-images.githubusercontent.com/36377165/183498782-9453516c-5049-4e75-b70a-86800ccf6bd1.png" width="300">

User authentication logic is build with Firebase Authentication. If user is new in the app or he logged up, he will see the home screen and will be able to log in or register new account.
Both the Log In Screen and the Sign Up screen consist 2 input fields and vailation for them.
Features not yet implemented 🚧: 
- Authentication via Google or Facebook
- Password recovery

# Lost internet connection error message

<img src="https://user-images.githubusercontent.com/36377165/183509088-9c5e317e-2b03-4a7e-b3b9-487008d1a0ec.png" width="300">

If user's phone has lost internet connection, he will se floating error message above app's UI (like Snackbar) with beautiful slide in and slide out animation
