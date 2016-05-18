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
* **core** is using Retrofit internally with GSON deserialisation
* **app** is using an abstract data loader which converts several of the models to UI objects which hide API implementation 

## App ##

### Components ###
All base components are organised in a separate package for reusability.

### Splash Screen ###
Configuration is being retrieved from the server during the splash screen. Shows a progress bar and a movie quote.

![Screenshot_20160518-134603.png](https://bitbucket.org/repo/gBjXLM/images/1655290595-Screenshot_20160518-134603.png)

### Error View ###
Error view is randomly displaying movie quotes from an author and a quote array. Backend errors are converted to custom UI errors.
IF the error is recoverable, it will show a Try Again button.

![Screenshot_20160518-134554.png](https://bitbucket.org/repo/gBjXLM/images/2862971167-Screenshot_20160518-134554.png)

### Home Activity ###
This is using a view pager with icons as tab names.
All Fragments implement a Searchable interface and are using a custom Searcher. They can be searched for multiple values such as name, year and genre.

![Screenshot_20160518-134534.png](https://bitbucket.org/repo/gBjXLM/images/1023503257-Screenshot_20160518-134534.png)

### Movie Feed Fragment ###
Recyclerview with cardviews, extends Media Fragment. Displays wrapper UI object that combines Movies with Genres through a factory.

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


# Still in progress! #