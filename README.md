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


# Still in progress! #