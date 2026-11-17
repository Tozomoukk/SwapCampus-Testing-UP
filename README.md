# SwapCampus · Testing exercise (Unfinished Project)

Exercise for the student presentation **Testing on Android: JUnit, Espresso & UI Automator**
(II.3510 Mobile Development, ISEP 2026-2027) by Eren Tekin and Amine Mouadni.

The slides are in this repository: `Testing on Android — JUnit, Espresso & UI Automator (SwapCampus).pptx`.

## The app

SwapCampus is a classifieds app for students, in Kotlin Multiplatform with Compose Multiplatform.
`:shared` contains the domain (listings, rules) and the repositories, `:composeApp` the screens and ViewModels,
`:androidApp` the `MainActivity`.

Demo accounts: `alice@isep.fr` / `1234`, `bob@isep.fr` / `1234`.

## Your job: write 4 tests

Each test below is empty and calls `TODO()`, so it fails until you write it. Hints are in the comments above each one.

| # | Level | File | What your test must check |
|---|---|---|---|
| 1 | Unit | `shared/src/commonTest/.../domain/ListingStatusTest.kt` | `canTransitionTo`: Available → Sold is refused, Sold → Available is allowed |
| 2 | Unit | `shared/src/commonTest/.../domain/ListingCatalogTest.kt` | `repostListing` gives a sold listing a new id and the status Available |
| 3 | Compose test | `androidApp/src/androidTest/.../PostListingTest.kt` | Publishing with an empty title shows "Give your listing a title." |
| 4 | UI Automator | `androidApp/src/androidTest/.../DeviceTest.kt` | On a listing's detail, the system Back button returns to the list |

Look at the tests that are already written in the same files: they show every API you need.

## Check your work

Exercises 1 and 2 (no device needed):

```
./gradlew :shared:testAndroidHostTest
```

At the start, 2 tests fail. When both exercises are done, every test passes.
The HTML report is in `shared/build/reports/tests/`.

Exercises 3 and 4: start an emulator **set to English** (the tests find screens by their English text), then:

```
./gradlew :androidApp:connectedAndroidTest
```

You can also click the green arrow next to a test in Android Studio to run it alone.

## Cheat sheet

| I want to… | Unit (kotlin.test) | Compose test | UI Automator |
|---|---|---|---|
| Find | – | `composeRule.onNodeWithText("Sell", useUnmergedTree = true)`, `onNodeWithTag("login_button")` | `device.findObject(By.text("Allow"))` |
| Act | call the function | `.performClick()`, `.performTextInput("25")`, `.performScrollTo()` | `device.pressBack()`, `device.setOrientationLeft()` |
| Check | `assertEquals`, `assertTrue`, `assertFalse`, `assertNotNull` | `.assertIsDisplayed()`, `.assertDoesNotExist()` | – (check with the Compose rule) |

Helpers already written for you in `androidApp/src/androidTest/.../UiTestHelpers.kt`:
`startLoggedOut()`, `fillLoginForm()`, `logInAsAlice()`.
