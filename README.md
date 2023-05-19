# MovieZone (Android)

---


## Supported Version
:star:	`Target Sdk Version: **`

:star:	`Minimum Sdk Version: **`

This sample uses the Gradle build system.

## Instructions

1. Download the samples by cloning this repository or downloading an archived snapshot.
2. In Android Studio, create a new project and choose the "Import non-Android Studio project" or "Import Project" option.
3. Select the App directory that you downloaded with this repository.
4. If prompted for a gradle configuration, accept the default settings. Alternatively use the "gradlew build" command to build the project directly.

## Libraries this app uses

1. [Material Designing](https://m3.material.io/develop/android/mdc-android)
2. [Firebase](https://firebase.google.com)
3. [Glide Image Loading](https://github.com/bumptech/glide)
4. [Kotlin](https://developer.android.com/kotlin/first)
5. [Retrofit Square Open Source](https://square.github.io/retrofit/)
6. [Firebase Analytics](https://firebase.google.com/docs/analytics/get-started?platform=android)
7. [Dependency Injection](https://developer.android.com/training/dependency-injection/hilt-android)
8. [Layout Design](https://developer.android.com/develop/ui/views/layout/constraint-layout)
9. [Architectural Pattern](https://www.codingninjas.com/codestudio/library/android-mvvm-model-view-viewmodel-architecture)
10. [Dependency Injection HILT](https://developer.android.com/training/dependency-injection/hilt-android)

## Keystores

ext.key_alias='**'
ext.key_password='**'
ext.store_password='**'
file_path = '**'

## Build variants
Use the Android Studio Build Variants button to choose between production and staging flavors combined with debug and release build types

## Generating signed APK
From Android Studio:

Build menu
Generate Signed APK...
Fill in the keystore information (you only need to do this once manually and then let Android Studio remember it)
 
## Development conventions

To maintain code quality, any change needs to be pushed to a branch and a pull request needs to be created.
The pull-request will be approved so that code gets merged into `develop` branch. Pull requests are rejected
if coding conventions are disrespected and sufficient log statements and exception handling while fixing an
issue or developing a feature are not present. You can find examples in the codebase on how to do so.
Before fixing any issue or developing a feature always take a pull from `develop` branch and specify the trello issue
link in the pull request. For every new issue or feature please create a separate branch and a separate pull request
from that branch to `develop`.

### Branch naming

- Branch names are in [kebab-case](http://wiki.c2.com/?KebabCase)
- Feature branch names should be like `feature/branch-name`
- Bugfix branch names should be like `bugfix/branch-name`
- All `feature` and `bugfix` branches get merged into `develop` branch regularly
- `develop` branch is merged with `master` to deploy app into production
- Before a pull request is approved, you need to provide a debug build to our testing team for testing and approval

### Commit message style

We want to use [Conventional Commits](https://www.conventionalcommits.org) spec for commit messages.

If you'd like to know more, see [this](http://karma-runner.github.io/3.0/dev/git-commit-msg.html)
and [this](https://seesparkbox.com/foundry/semantic_commit_messages).

### Android code style

We have used Kotlin to develop our project. Please refer to [Kotlin coding style](https://kotlinlang.org/docs/reference/coding-conventions.html).

### Manage Gradle dependencies 
 - [Dependency management using buildSrc](https://medium.com/doubletapp/how-to-manage-gradle-dependencies-in-the-android-project-proper-way-dad51fd4fe7)
