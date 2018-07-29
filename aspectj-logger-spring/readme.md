# Aspectj-Logger-Spring
Example for log any kind of visibility method execution using AspectJ with Spring beans.
It can be compiled and run as any other spring application.

# Restrictions
Spring AOP on run time just can proxy ``public`` methods.
For weaving other method visibility, use complie or loaded time weaving.
