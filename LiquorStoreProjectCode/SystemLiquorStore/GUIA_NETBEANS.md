# Primera versión de consola: Liquor Store System

Esta entrega implementa las operaciones del proyecto en consola. Los datos se mantienen durante la sesión; al salir se pierden porque todavía no se utiliza JSON. La persistencia y las pruebas unitarias quedan para las siguientes etapas.

## Abrir el proyecto completo en NetBeans

1. Extrae el ZIP recibido en una carpeta de trabajo distinta de tu proyecto anterior. Si la versión anterior está abierta en NetBeans, usa **Close Project** para distinguir ambas copias; sus archivos se conservan.
2. En NetBeans selecciona **File → Open Project** y abre la carpeta **SystemLiquorStore**, que contiene `build.xml`, `nbproject` y `src`.
3. En la ventana **Projects**, haz clic derecho sobre el proyecto recién abierto y selecciona **Run**. Si lo estableces como proyecto principal, también puedes usar **F6**. Los menús aparecen en **Output**; escribe ahí las respuestas y pulsa Enter.
4. Si el IDE solicita una clase principal, selecciona `ec.edu.espe.systemliquorstore.view.LiquorStoreSystem`.

Con esta opción no tienes que crear otro proyecto ni pegar los archivos uno por uno. La carpeta entregada ya tiene la organización del proyecto Java con Ant. No necesitas descargar bibliotecas ni agregar dependencias de JSON o JUnit. Utiliza JDK 17 o superior; en tu equipo se identificó JDK 27. El proyecto incluye la configuración UTF-8 para mostrar correctamente los acentos.

## Organización del código

```text
SystemLiquorStore/
├── build.xml
├── nbproject/
└── src/ec/edu/espe/systemliquorstore/
    ├── model/
    │   ├── Product.java
    │   ├── StockMovement.java
    │   ├── Supplier.java
    │   ├── PurchaseOrder.java
    │   ├── PurchaseOrderItem.java
    │   ├── Sale.java
    │   ├── SaleItem.java
    │   ├── Customer.java
    │   ├── CustomerPayment.java
    │   ├── DailyCashRecord.java
    │   └── CashExpense.java
    ├── util/
    │   └── Validation.java
    └── view/
        └── LiquorStoreSystem.java
```

- **model:** las 11 clases de negocio del diagrama. Guardan datos y realizan las operaciones y cálculos.
- **view:** muestra los menús en español, recibe las respuestas y conserva las listas de registros durante la sesión.
- **util:** `Validation` reúne validaciones y redondeos que utilizan varias clases. Sus métodos son métodos normales de un objeto.

Los identificadores del código están en inglés y los textos que ve el cliente están en español. Los archivos Java se entregan sin comentarios. El único método declarado `static` es `main`, el punto de entrada que Java utiliza para iniciar el programa.

## Qué cambia frente a los 17 archivos anteriores

### Reemplazar estos cinco archivos

| Archivo | Cambio principal |
|---|---|
| `model/Product.java` | Código del producto, costo, precio, stock y mínimo; entradas, salidas y alertas. |
| `model/Sale.java` | Venta con detalles, vendedor, contado/crédito, descuento, confirmación de edad y actualización de inventario al completar. |
| `model/Customer.java` | Cliente con saldo calculado desde sus ventas a crédito y pagos; ya no se escribe una deuda inicial manualmente. |
| `model/Supplier.java` | Identificador, nombre, contacto y creación de pedidos. |
| `view/LiquorStoreSystem.java` | Menú completo y listas compartidas durante la sesión. Sustituye los imports y las llamadas del simulador anterior. |

### Agregar estas clases al paquete `model`

| Archivo | Para qué sirve |
|---|---|
| `StockMovement.java` | Registra una entrada o salida de inventario. |
| `PurchaseOrder.java` | Pedido pendiente y confirmación de una entrega completa. |
| `PurchaseOrderItem.java` | Producto y cantidad solicitados en un pedido. |
| `SaleItem.java` | Producto vendido, cantidad y copia de sus costos y precios históricos. |
| `CustomerPayment.java` | Un abono de un cliente, con fecha e importe. |
| `DailyCashRecord.java` | Apertura, gastos, conteo físico y conciliación de caja de una fecha. |
| `CashExpense.java` | Descripción e importe de un gasto de caja. |

Agrega también `Validation.java` al paquete `ec.edu.espe.systemliquorstore.util`.

### Retirar del proyecto activo estas doce clases anteriores

`Alert`, `Business`, `Cashier`, `Employee`, `Entry`, `Item`, `Ledger`, `PointOfSale`, `Record`, `Report`, `Store` y `Transaction`.

Se conservan en el respaldo del proyecto anterior, fuera del `src` activo. Sus responsabilidades cambiaron: los detalles pasan a `SaleItem`, la caja a `DailyCashRecord`, las alertas se consultan desde los productos y los reportes se muestran desde el menú. `Owner` y `Cashier` son roles del diagrama de casos de uso; no obligan a conservar una clase Java llamada `Cashier`.

### Alternativa: actualizar a mano tu proyecto anterior

1. Haz primero una copia completa del proyecto anterior como respaldo.
2. En el proyecto que vas a actualizar, reemplaza los cinco archivos indicados y agrega las ocho clases nuevas: siete en `model` y una en `util`.
3. Retira las doce clases antiguas del paquete activo. No dejes copias de sus archivos `.java` dentro de `src`.
4. Conserva exactamente los paquetes `ec.edu.espe.systemliquorstore.model`, `ec.edu.espe.systemliquorstore.view` y `ec.edu.espe.systemliquorstore.util`. El nombre de cada archivo debe coincidir con el nombre de su clase.
5. Haz clic derecho sobre el proyecto, selecciona **Clean and Build** y después **Run**. Si pide la clase principal, elige la indicada al inicio de esta guía.

Utiliza una de las dos formas: abrir el proyecto completo o copiarlo manualmente. Evita mezclar archivos de ambas versiones dentro del mismo `src`.

## Menú principal

| Opción | Operación |
|---|---|
| 1 | Productos e inventario: registrar, consultar, actualizar y registrar entradas o salidas. |
| 2 | Consultar alertas de stock bajo. |
| 3 | Proveedores, pedidos y confirmación de entregas. |
| 4 | Registrar una venta, con descuento opcional y confirmación de edad. |
| 5 | Clientes, deudas, historial y pagos. |
| 6 | Apertura, gastos, conteo y conciliación diaria de caja. |
| 7 | Consultar ganancia bruta y margen. |
| 8 | Consultar ventas por vendedor. |
| 9 | Consultar productos más vendidos en un período. |
| 10 | Cargar datos ficticios de demostración, únicamente si la sesión está vacía. |
| 0 | Salir del programa. |

Las diez funcionalidades del backlog están contempladas: descuentos y verificación de edad forman parte de la opción 4. La opción 10 es una ayuda para presentar el programa, no una funcionalidad adicional del cliente.

## Cómo registrar una venta

1. Entra en la opción **4**.
2. Selecciona vendedor: **1 = propietario**, **2 = empleado**.
3. Escribe la fecha en formato `AAAA-MM-DD`, o pulsa Enter para utilizar la fecha actual.
4. Selecciona **1 = contado** o **2 = crédito**. Para crédito, elige un cliente registrado.
5. Escribe el código de un producto y su cantidad. Repite para agregar más productos. Deja el código vacío y pulsa Enter cuando termines.
6. Responde **s** si vas a aplicar un descuento autorizado y escribe su porcentaje. Responde **n** si no corresponde; equivale a un descuento de **0**. Se aplica al subtotal completo.
7. Revisa el resumen y confirma la verificación de edad con **s** o cancela con **n**.
8. Confirma el registro final con **s** o cancela con **n**.

La venta confirmada reduce el stock una sola vez. Una venta a crédito genera deuda, pero todavía no representa dinero recibido en caja. Una cancelación deja inventario y saldos sin cambios. Si después cambias el precio de un producto, sus ventas anteriores conservan los precios y costos utilizados al vender.

## Recorrido corto para presentar al profesor

Empieza con una sesión nueva. Todos los movimientos del ejemplo deben utilizar la misma fecha.

1. Elige **10** para cargar los datos ficticios:

   | Código | Producto | Costo | Precio | Stock | Mínimo |
   |---|---|---:|---:|---:|---:|
   | P001 | Cerveza | 8.00 | 10.00 | 20 | 5 |
   | P002 | Vino | 12.00 | 15.00 | 10 | 3 |
   | P003 | Agua | 0.50 | 0.75 | 3 | 3 |

   También se crean un proveedor y un cliente con identificador **1**. La opción **2** debe mostrar la alerta del agua porque su stock es igual al mínimo.

2. En **4**, registra una venta de contado de **P001**, cantidad **1**, sin descuento (responde **n**). Confirma edad y registro. El total esperado es **USD 10.00**.
3. En **4**, registra una venta a crédito de **P001**, cantidad **2**, para el cliente **1**, sin descuento (responde **n**). Su deuda esperada es **USD 20.00**. Tras las dos ventas, quedan **17** cervezas.
4. En **5**, consulta al cliente y registra un pago de **USD 5.00**. Su saldo pendiente debe quedar en **USD 15.00**.
5. En **6**, registra apertura de **USD 100.00** para esa fecha, un gasto de **USD 3.00** y un conteo físico de **USD 112.00**.
6. Consulta la conciliación. El cálculo esperado es:

   `100.00 + 10.00 de contado + 5.00 de abono − 3.00 de gasto = 112.00`

   La diferencia esperada es **USD 0.00**. Los **USD 20.00** vendidos a crédito no se suman al efectivo.

7. En **7**, revisa la ganancia y el margen. Sin descuentos, cada cerveza vendida deja **USD 2.00** de ganancia bruta y **20%** de margen sobre su precio de venta. En las tres unidades del ejemplo: venta total **USD 30.00**, costo **USD 24.00**, ganancia **USD 6.00** y margen **20%**.
8. Consulta **8** para ver las ventas por vendedor y **9** para ver las unidades vendidas. El período debe incluir la fecha utilizada; P001 debe acumular **3 unidades**, incluyendo la venta a crédito.

Para mostrar proveedores y pedidos, usa **3**, crea un pedido de un producto registrado y confirma su entrega completa. El stock debe aumentar; el mismo pedido no puede recibirse dos veces.

## Verificación realizada

El código fue compilado con JDK 27 y compatibilidad Java 17. La compilación de NetBeans mediante Ant generó el JAR correctamente. Se verificaron recorridos completos de consola para ventas, inventario, pedidos, crédito, pagos, caja, reportes y cancelaciones; también se comprobó el redondeo de un descuento del 10% sobre USD 1.15: descuento USD 0.12 y total USD 1.03. Esto no incorpora todavía la batería de pruebas unitarias.

## Qué queda para después

Esta es la primera versión de consola para revisar y presentar. Después se incorporarán la persistencia JSON y las pruebas unitarias previstas en los documentos. La interfaz gráfica corresponde a una etapa posterior. No cambies las reglas de negocio al agregar esas partes: reutiliza las clases del paquete `model`.

Referencia de ejecución en NetBeans: https://netbeans.apache.org/tutorial/main/kb/docs/java/javase-intro/
