# Decision-Visitor Pattern

[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)

A Java implementation of the Visitor design pattern focused on conditional decision-making logic.

## Overview

This project demonstrates the Visitor pattern applied to a decision-making framework. The implementation allows for composable, testable conditions and decisions with clean separation of concerns.

Key concepts implemented:
- **Condition Hierarchy**: Basic building blocks for decisions
- **Visitor Pattern**: For traversing and processing condition trees
- **Composition**: Creating complex conditions from simpler ones

## Project Structure

### Core Model (`ch.wylan.decision.model`)

- `Condition<E>`: Base class for all conditions
- `Decision<E>`: Represents a decision to be made
- `Rule<E>`: Combines a condition, decision, and alternative
- `CompositionCondition<E>`: Abstract class for composite conditions
- `AndCondition<E>` & `OrCondition<E>`: Logical compositions
- `IConditionVisitor<E,T>`: Visitor interface for traversing condition trees
- `AbstractConditionVisitor<E,T>`: Base implementation for visitors

### Example Domain (`ch.wylan.decision.guestmodel`)

The project includes a sample application modeling a party venue with different types of lounges and guest registration rules:

- Different lounge types (VIP, Public, Birthday, Golden)
- Guest classification system
- Registration and placement rules

## How It Works

The core concept is building a tree of conditions using composition to represent complex decision logic:

```java
// Simple condition composition
Condition<Data> condition = new ConditionA()
    .and(new ConditionB())
    .or(new ConditionC());

// Using with a visitor
Result result = condition.accept(new MyVisitor());
```
The visitor pattern allows for flexible operations on the condition tree without modifying the condition classes themselves.

## Example Usage

```java
// Define a condition
Condition<PartyRegistrationOrder> registrationCondition =
new VipCondition()
.and(new FreeVipSeatCondition())
.or(new FreeSeatCondition());

// Use visitor to process the condition
PartyRegistration registration = new PartyRegistration();
Placement placement = registration.register(new PartyRegistrationOrder(location, guest));
```

# Getting Started

## Prerequisites

* Java 17+ (recommended)
* Maven 3.6+

## Building the Project

```bash
mvn clean install
```

## Running Tests

```bash
mvn test
```

