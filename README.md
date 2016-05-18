# Movie DB Client Demo for Android #
Android Material Design application for accessing Movie DB data using a guest account.

## Structure ##
The application is using 3 modules:
 
* **common** (library): contains base models and utility objects
* **core** (library): contains internal data providers, app models and basic interfaces / response objects, and core business logic
* **app**: contains base UI components, their implementations and dedicated data loaders.

## Build ##
### Built Types ###
* **release** for store release
* **debug** for debugging the application and enabling loggin
* all build types automatically generate their APK filename using the current git commit information
### Flavours ###
* **prod** using the production server
* **dev** using the debug proxy
* **mock** using the mock server
### Data Fetching ###
* **core** is using Retrofit internally with GSON deserialisation. All app models are represented by interfaces and are paired with their implementations during GSON initialisation.
* **app** is using an abstract data loader which converts several of the models to UI objects which hide API implementation 

* Retrieved server configuration is stored in a shared preference. This is done in order to store the Base Image URL before starting the application proper.
* All network data loading is done in a background thread. UI loaders will run the success / error result on the UI thread automatically.
* UI loaders take care of chaining the request to a Data Provider (acts as a facade) who chains the request to a network loader for separation of concerns.
* Data retrieved from the network gets validated through a generic ValidatorProcessor who picks the correct Validator for each Class type and produces a ValidationResult.
* Backend errors are converted to custom UI errors through an internal converter.

## App ##

### Components ###
* All base components are organised in a separate package for reusability.
* Application class inititalises the **Core module singleton** for access to the Data Provider and **Crasylytics** controller.
* Activities and Fragments keep a reference to an **Intent Dispatcher** and an **Image Fetcher** (Picasso Singleton) which they provide to their view binders.

### Splash Screen ###
Configuration is being retrieved from the server during the splash screen. Shows a progress bar and a movie quote.

![Screenshot_20160518-134603.png](https://bitbucket.org/repo/gBjXLM/images/1655290595-Screenshot_20160518-134603.png)

### Error View ###
Error view is randomly displaying **movie quotes** from an author and a quote array.
IF the error is recoverable, it will show a Try Again button.
Components use a **StateKeeper** to handle their current state (loading, error, empty, content).

![Screenshot_20160518-134554.png](https://bitbucket.org/repo/gBjXLM/images/2862971167-Screenshot_20160518-134554.png)

### Home Activity ###
This is using a view pager with icons as tab names.
All Fragments implement a Searchable interface and are using a custom Searcher. They can be searched for multiple values such as name, year and genre.

![Screenshot_20160518-134534.png](https://bitbucket.org/repo/gBjXLM/images/1023503257-Screenshot_20160518-134534.png)

### Movie Feed Fragment ###
Recyclerview with cardviews, extends Media Fragment. Displays wrapper UI object that combines Movies with Genres through a factory. Uses an AutoFitLayout for genres.

![Screenshot_20160518-134512.png](https://bitbucket.org/repo/gBjXLM/images/4005901145-Screenshot_20160518-134512.png)

### People Feed Fragment ###
Recyclerview with cardviews.

![Screenshot_20160518-134516.png](https://bitbucket.org/repo/gBjXLM/images/1488809604-Screenshot_20160518-134516.png)

### Tv Series Feed Fragment ###
Recyclerview with cardviews, extends Media Fragment. Displays wrapper UI object that combines TvSeries with Genres through a factory.

![Screenshot_20160518-134520.png](https://bitbucket.org/repo/gBjXLM/images/2904125364-Screenshot_20160518-134520.png)

### Movie Details ###
Activity with a Collapsing Layout and a Fragment.

![Screenshot_20160518-134504.png](https://bitbucket.org/repo/gBjXLM/images/2389392838-Screenshot_20160518-134504.png)
![Screenshot_20160518-134508.png](https://bitbucket.org/repo/gBjXLM/images/2521186092-Screenshot_20160518-134508.png)

### Tv Series Details ###
Activity with a Collapsing Layout and a Fragment. Reusing the Movie Details infrastructure due to time constraints, although I would have preferred to write a new screen for it

![Screenshot_20160518-143733.png](https://bitbucket.org/repo/gBjXLM/images/431905170-Screenshot_20160518-143733.png)
![Screenshot_20160518-143746.png](https://bitbucket.org/repo/gBjXLM/images/3351930293-Screenshot_20160518-143746.png)

## Unit Tests ##
* Several utility classes have been unit tested. Time constraints did not allow for further testing. 

## Known Issues ##
* Collapsing bar layout will not scroll properly in the case of a lot of details. It can be fixed, but time constraints did not allow me to address the issue.

## Stretch Goals ##
* UI should only show UI models and should not be aware of back-end implementations for separation of concerns.