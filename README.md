**Task 2 -- Rest Assured Test Automation**

**Test cases proposed for Automation:**

**1) Endpoint: Pet**

a\) Creation of a new pet

b\) Getting a list of pets available

c\) Finding a pet with the id

d\) Updating a pet detail

**2) Endpoint: User**

a\) Getting user details with username

b\) Creating a new user

c\) Activating and deactivating a session (Log in and Log out)

d\) Updating user detail

e\) Deleting a user

**3) Endpoint: Store**

a\) Creating a new order

b\) Finding an order using id

c\) Finding list of orders

\>\> Possibilities of automating above scenarios are quite high if the
server level API works as expectation which is the focus of automation,
thus reduction of overall time of actual manual inputs. But there could
be some pros and cons such as:

Pros:

a\) Reduction in execution time using automation which could otherwise
be taken by manually testing API's.

b\) The proposed APIs are the ones which hold the core functionality of
the swagger provided, thus implementing them would ensure the maximum
testing coverage for the APIs.

Cons:

a\) The Open-API becomes unstable at times, and it could alter the
results of automation test suite providing altered results.

b\) The automation results could be impacted when the server is not
available or the changes in the API's are made by the development team.

\>\> ReadMe.md file provides the details of Automated framework for
Open-API

The automation project is for Pet Store API based on Rest Assured
Framework for which some of the prerequisites are as follows:

a\) Java Installation: Verify with help of java -version in the command
prompt of the machine

b\) IDE such as Eclipse/IntelliJ, etc.

c\) Clone the project from
<https://github.com/swagger-api/swagger-petstore>

d\) After cloning the project, Right click the project and Run As - \>
Maven Build (clean jetty:run) for the project to start the Jetty Server

e\) Visit <http://localhost:8080> to check if the server is up

Note: Implementation is done in two ways to ensure the API's are
working:

a\) Localhost APIs for Pet Store swagger -- Using Jetty

b\) Public URL APIs for Pet Store swagger -- Using accessible URLs

Part b is done in order to maintain consistency and results of the APIs
as sometimes, localhost API's become unstable.

**Run Test**

a\) Right-click the project and select, Run As - \> Maven test

b\) Once the execution is completed you would find the following:

> i\) Sure-fire reports - \> emailable reports as follows:
>
> ii\) JSON Files generated in src/test/java as the result of some POST
> and PUT requests used in Swagger APIs

**Project Structure for Test Files**

a\) You will find src/test/java package where following are the
packages:

i\) ip.swagger.petstoretests with PetStore Test, Store/Order Tests, User
Tests and Negative Test

ii\) ip.swagger.petstoretests.publicURL with PetStore Test, Store/Order
Tests, User Tests and Negative Test with Swagger Pet Store stable from
URL

iii\) ip.swagger.resources with ReadConfigUtility.java and
config.properties files where the former implements the access to latter
file in the package

iv\) JSON files, which are generated as a result of execution of the
POST and PUT api's.

**Tools:**

a\) Eclipse IDE

b\) Rest-Assured

c\) Maven

d\) Java

e\) Git-Hub

**Further Improvement areas:**

a\) Reports can be implemented using TestNg

b\) Using excel file for Data Management

