# Liquor Store System - Console Version

Logical Lords - first console milestone.

## Run

Open this folder as an existing Java with Ant project in NetBeans, then right-click this project and select Run (or use F6 when it is the main project). Main class: `ec.edu.espe.systemliquorstore.view.LiquorStoreSystem`.

JDK 17 or later; verified with the locally installed JDK 27 and the NetBeans Ant runtime. No external libraries are required. Source and console encoding are UTF-8.

For Spanish setup, migration instructions and a presentation walkthrough, see `GUIA_NETBEANS.md`.

## Scope

All data remains in memory for the current process. JSON persistence and unit tests are intentionally deferred to the next stage requested by the team. The optional demo command adds clearly labeled fictitious data only to an empty session.

| Story | Implemented behavior |
|---|---|
| US001 | Product registration, editing, stock entries/exits and movement history. |
| US002 | Minimum stock levels and current low-stock alerts. |
| US003 | Supplier registration, purchase orders and one-time full receipt. |
| US004 | Cash/credit sales, historical line values and seller reports. |
| US005 | Customer accounts, credit purchases, payment history and balances. |
| US006 | Daily opening cash, expenses, physical count and reconciliation. |
| US007 | Gross profit and actual gross margin from historical costs. |
| US008 | Optional owner-authorized sale-wide percentage discounts. |
| US009 | Product ranking by units in completed sales within inclusive dates. |
| US010 | Age-check reminder, confirmation and cancellation before completion. |

## Organization

- `model`: the 11 agreed business classes.
- `util.Validation`: common value/date checks and money rounding.
- `view.LiquorStoreSystem`: console menus, user input and session collections.

Business methods perform no console or file I/O. Domain actions retain their void return types. Invalid requests use standard Java exceptions which the console converts to Spanish messages. Only the main entry point is declared static. No custom interfaces, inheritance hierarchy, streams or database are used.

## Verification

Compilation with `javac --release 17 -encoding UTF-8 -Xlint:all` succeeded without diagnostics. The NetBeans Ant build produced the executable JAR successfully. End-to-end console walkthroughs verified cash and credit sales, payments, stock and delivery history, duplicate receipt rejection, discounts, cancellations, seller/date filters, ranking, historical prices and daily cash. A discount of 10% on USD 1.15 rounds to USD 0.12, giving USD 1.03 total.

The sample reconciliation gives USD 100 opening + USD 10 cash sale + USD 5 debt payment - USD 3 expense = USD 112 expected cash, zero difference at a USD 112 count, and USD 15 remaining debt after a USD 20 credit purchase.

Primitive double values retain floating-point limitations; the rounding helper compensates errors close to a half-cent in ordinary calculations. Persistence and the planned independent unit-test suite remain pending.
