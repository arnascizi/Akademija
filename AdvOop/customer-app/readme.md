### 1. Exercise: Make it work
At the moment the application is not finished and does nothing.

**Requirements:**

* It should be possible to save customers, delete customers and fetch all customers.

**Acceptance criteria:**

* MainController uses CustomerRepository for insert/delete/fetch operations.

* It's possible to insert, delete and display Customers.

**Hint:** For CustomerRepository instance inside MainController a simple initialization through constructor or springs dependency injection can be used.

**Input/Output tests for finished exercise:**

1. [I/O Test 1](https://github.com/enorkus/customer-app-io/blob/master/1.solution.png)

### 2. Exercise: Apply some formatting and decouple
Let’s apply some formatting for certain inputs. As we add more code it’s apparent that business logic must also be decoupled from other layers.

**Requirements:**

* No matter how a user entered their first and last name they should always be saved with first letters capitalized. Personal number should have a dash after first 4 digits.

**Acceptance criteria:**

* CustomerRepository is converted to interface.
* MemoryCustomerRepository implements CustomerRepository.
* Data persistence is decoupled from MainController by creating CustomerService. 
* CustomerService uses MemoryCustomerRepository.
* All formatting takes place in the CustomerService.
* First name and last name of Customer are capitalized after saving (john smith must appear in the table as John Smith)
* Personal number has a dash after first 4 digits after saving (entering 123456789 and saving must end up as 1234-56789 in the table)
* Submitting should not fail trying to submit empty values or if personal number is less than 4 characters.

**Input/Output tests for finished exercise:**

1. [I/O Test 1](https://github.com/enorkus/customer-app-io/blob/master/2.solution.png)
2. [I/O Test 2](https://github.com/enorkus/customer-app-io/blob/master/2.1.solution.png)

### 3. Exercise: Did you just mutate that data?
In software development data mutation (mutability) is an unwanted side effect of programming which should be avoided as much as possible.

**Requirements:**

* The mutated Customer properties (first name, last name and personal number) should not be set onto the same Customer object coming from MainController. To make things right, a new Customer object with all the same properties from old Customer, plus new first name, last name and personal number should be created. To make things even better - builder pattern should be implemented.

**Acceptance criteria:**

* Customer object is not mutated before passing it to CustomerRepository.
* New instance of Customer is created with all original Customer's data plus formatted ones.
* To create Customer object a builder pattern is used.

**Hint:** Three attributes - first name, last name and personal number are mandatory. 
Note: Make an exception and leave setter for customer id, since it's used to determine which of the customers has to be deleted, but don't include it in the builder.

**Input/Output tests for finished exercise:**

1. [I/O Test 1](https://github.com/enorkus/customer-app-io/blob/master/3.solution.png)

### 4. Exercise: Input validation
At the moment users can enter almost anything they want and it would get stored. The application needs validation to check for invalid input.

**Requirements:**

* First name, last name and personal number are marked as mandatory inputs in frontend. Validation for those 3 attributes and age has to be implemented.

**Acceptance criteria:**

* Validation for mandatory attributes: first name, last name and personal number is implemented.
* Validator class is implemented to validate the input before formatting/storing.
* Validator throws existing MandatoryValueMissingException if any of the mandatory inputs are missing.
* An appropriate validation messages are passed to MandatoryValueMissingException when throwing them.
* Validator class is used inside CustomerService.
* HTTP error code 422 and appropriate message is seen under table when trying to submit invalid inputs.
* Submitting spaces as input should also fail with the same exception and message.

**Input/Output tests for finished exercise:**

1. [I/O Test 1](https://github.com/enorkus/customer-app-io/blob/master/4.solution.png)
2. [I/O Test 2](https://github.com/enorkus/customer-app-io/blob/master/4.1.solution.png)
3. [I/O Test 3](https://github.com/enorkus/customer-app-io/blob/master/4.2.solution.png)
4. [I/O Test 4](https://github.com/enorkus/customer-app-io/blob/master/4.3.solution.png)

### 4.1 Exercise: Input validation

**Requirements:**
* Age is now also a mandatory input, so validation for age restriction has to be implemented. Also only LT, LV, EE and SE are accepted as country code values if one was provided.

**Acceptance criteria:**

* New type of validation Exception class CustomerNotAdultException created for age validation. HTTP code should be the same as for MandatoryValueMissingException.
* Validation for age is implemented: age is mandatory and cannot submit customer with age less than 18.
* Enum class for country codes is created containing following values: LT, LV, EE, SE
* New type of validation Exception - InvalidCountryCodeException is created for country code validation. HTTP code should be the same as for MandatoryValueMissingException.
* Validation exception is thrown when trying to submit customer with age under 18.
* Validation exception is thrown when trying to submit customer with country code other than LT, LV, EE or SE. Country code validation id not triggered if no country code was provided at all.

**Hint:** See the way MandatoryValueMissingException is constructed. A default message can be passed to @ResponseStatus annotation by attribute: reason = “Message text”.

**Input/Output tests for finished exercise:**

1. [I/O Test 1](https://github.com/enorkus/customer-app-io/blob/master/4-1.solution.png)
2. [I/O Test 2](https://github.com/enorkus/customer-app-io/blob/master/4-1.1.solution.png)
3. [I/O Test 3](https://github.com/enorkus/customer-app-io/blob/master/4-1.2.solution.png)
4. [I/O Test 4](https://github.com/enorkus/customer-app-io/blob/master/4-1.3.solution.png)
5. [I/O Test 5](https://github.com/enorkus/customer-app-io/blob/master/4-1.4.solution.png)

### 5 Exercise: Reusable validators

**Requirements:**
* Let’s imagine customer application is way bigger than it is and we need to validate a bunch of similar attributes that we validate for Customer object. Let’s create reusable validators just for those purposes.

**Acceptance criteria:**

* Abstract class Validator<T> accepting generic T is created.
* Abstract Validator has a single method: public abstract void validate(T attribute, String message).
* 3 Separate validators created extending the abstract Validator class: MandatoryValueValidator, CustomerAdultValidator, CountryCodeValidator.
* Single Exception: ValidationException created instead of previous 3.
* ValidationException is constructed with String message.
* CustomerValidator methods replaced with the newly created Validator classes.
* New validators are created and called inside CustomerValidator.
* ValidationException along with message is thrown when validation fails.
* All validation logic stays the same - input output tests are same as for exercise 4.1


