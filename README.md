## Technologies:

* Java 1.8
* Spring Boot 2.3.5.RELEASE
* Maven 3.6.3
* Swagger 2.9.2

## Thread safety:
Project is thread safe, as there are only calculations capsuled in functions. No possible shared data.

## Restrictions
The program works with numbers up until 9223372036854775807 ( ==Long.MAX_VALUE)

## Time/Space complexity and optimizations
* Prime number check - Just checking for a divisor until
sqrt N -> so time complexity sqrt N; No memory/caching used for optimization.
Constant memory. 

* Find next prime number - Checking if N is prime and then check if each next
odd number is prime until one is found -> complexity n*sqrt n.No memory/caching used for optimization.
Constant memory. 



