# School-Management-System
# Setup instructions
Clone the Repository
git clone <repository-url>
cd project-directory
Open in Android Studio
Launch Android Studio and open the project.
Ensure all dependencies are installed.
Configure API Base URL
Update the API endpoint in the network package.
Run the Project
Connect a device or emulator and run the project.
# Features implemented
**Authentication**

Login screen with authentication against the mock API.

Secure storage of authentication tokens.

Handling of authentication errors and invalid credentials.

**Dashboard**

Displays a summary:

Number of schools

Number of camps

Number of students

**Schools Management**

List of schools with basic information.

Detailed school view.

Ability to add a new school.

**Camps Management**

List of learning camps.

Detailed view of each camp, including assigned students.

Ability to create a new camp.

**Students Managemen**t

List of students.

Detailed student information view.

Ability to add a student and assign them to a camp.
# Architecture overview
MVVM Architecture for clear separation of concerns.

Kotlin Coroutines for handling asynchronous tasks.

Navigation Component for seamless screen transitions.

Repository Pattern for data management.
# Any libraries or tools used
Retrofit – For API communication.

Coroutines – For handling asynchronous operations.

ViewModel & LiveData – For UI state management.

Room Database – This is for offline storage and caching.
# Challenges faced and how you overcame them
throughout the week i have been having challenges with my internet connections and power shortages.
