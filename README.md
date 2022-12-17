## spring-observer-event-support
Simple project created to evaluate observer pattern from spring implementation

The main idea behind this project is to test the behavior of:
- org.springframework.context.ApplicationEventPublisher
- org.springframework.context.event.EventListener

ApplicationEventPublisher is a bean managed by Spring Context and it implements Observer Pattern.
EventListener is an annotation used to define a method as receiver. The methods annotated as @EventListener will be notified by ApplicationEventPublisher.

The contract should be respected. It means that ApplicationEventPublisher will notify a well defined object. Then the signature of the receiver method should be defined according to the same class / object sent by the publisher.
