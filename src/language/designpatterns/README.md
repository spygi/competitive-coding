## Visitor pattern

- (Abstract or Interface) Visitor with visit methods for each concrete type of Element (taken as input)
  - Concrete implementations are based on the functionality you want to achieve (1:1).
- (Abstract or Interface or no relationship at all) Element with accept method for _a_ Visitor
  - Implementations call the specific visitors' visit method (with this as input)
  - Composite Elements can either have the traversal logic on themselves or in the Visitor if the traversal is too complex
  and depends on the result of the traversal of the components, see AvailabilityVisitor.

### Use cases:
- You need to perform operations on objects based on their concrete type.
These objects might be of the same abstract type (Interface or Abstract) or not (ore flexible than iterator pattern)
- Many different operations need to be performed. With a visitor you put all the functionality in one class.
- The objects rarely change (types of calendars) but you regurarly add features/functionality to them.

### Limitations/shortcomings:
- Visitor implementations can not return whatever type they want because they have to have the same contract.
- Breaks encapsulation by delegating functionality to the visitors.