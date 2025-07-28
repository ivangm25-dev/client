# Virtual Client.
Basic Api for list client.

## Version: 1.0.0

### /client

#### GET
##### Description:

Returns a list of clients.

##### Responses

| Code | Description | Schema |
| ---- | ----------- | ------ |
| 200 | Successful | [ [ResponseClientDTO](#ResponseClientDTO) ] |
| 400 | Bad Request | [ [ErrorMessageDTO](#ErrorMessageDTO) ] |
| 500 | Internal Error | [ [ErrorMessageDTO](#ErrorMessageDTO) ] |

#### POST
##### Description:

Create new client.

##### Parameters

| Name | Located in | Description | Required | Schema |
| ---- | ---------- | ----------- | -------- | ---- |
| client | body | Object RequestClientDTO | Yes |  |

##### Responses

| Code | Description | Schema |
| ---- | ----------- | ------ |
| 201 | Successful | [ [ResponseClientDTO](#ResponseClientDTO) ] |
| 400 | Bad Request | [ [ErrorMessageDTO](#ErrorMessageDTO) ] |
| 500 | Internal Error | [ [ErrorMessageDTO](#ErrorMessageDTO) ] |

#### PUT
##### Description:

Update Client.

##### Parameters

| Name | Located in | Description | Required | Schema |
| ---- | ---------- | ----------- | -------- | ---- |
| client | body | RequestClientDTO | Yes |  |

##### Responses

| Code | Description | Schema |
| ---- | ----------- | ------ |
| 200 | Successful | [ [ResponseClientDTO](#ResponseClientDTO) ] |
| 400 | Bad Request | [ [ErrorMessageDTO](#ErrorMessageDTO) ] |
| 500 | Internal Error | [ [ErrorMessageDTO](#ErrorMessageDTO) ] |

### /client/{clientId}

#### GET
##### Description:

Delete Client By Id.

##### Parameters

| Name | Located in | Description | Required | Schema |
| ---- | ---------- | ----------- | -------- | ---- |
| clientId | path |  | Yes | string |

##### Responses

| Code | Description | Schema |
| ---- | ----------- | ------ |
| 200 | Successful | [ [MessageDTO](#MessageDTO) ] |
| 400 | Bad Request | [ [ErrorMessageDTO](#ErrorMessageDTO) ] |
| 500 | Internal Error | [ [ErrorMessageDTO](#ErrorMessageDTO) ] |

### /loan

#### GET
##### Description:

Returns a list of loans.

##### Responses

| Code | Description | Schema |
| ---- | ----------- | ------ |
| 200 | Successful | [ [ResponseLoanDTO](#ResponseLoanDTO) ] |
| 400 | Bad Request | [ [ErrorMessageDTO](#ErrorMessageDTO) ] |
| 500 | Internal Error | [ [ErrorMessageDTO](#ErrorMessageDTO) ] |

#### POST
##### Description:

Create new loan.

##### Parameters

| Name | Located in | Description | Required | Schema |
| ---- | ---------- | ----------- | -------- | ---- |
| loan | body | Object RequestLoanDTO | Yes |  |

##### Responses

| Code | Description | Schema |
| ---- | ----------- | ------ |
| 201 | Successful | [ [ResponseLoanDTO](#ResponseLoanDTO) ] |
| 400 | Bad Request | [ [ErrorMessageDTO](#ErrorMessageDTO) ] |
| 500 | Internal Error | [ [ErrorMessageDTO](#ErrorMessageDTO) ] |

#### PUT
##### Description:

Update Loan.

##### Parameters

| Name | Located in | Description | Required | Schema |
| ---- | ---------- | ----------- | -------- | ---- |
| loan | body | RequestLoanDTO | Yes |  |

##### Responses

| Code | Description | Schema |
| ---- | ----------- | ------ |
| 200 | Successful | [ [ResponseLoanDTO](#ResponseLoanDTO) ] |
| 400 | Bad Request | [ [ErrorMessageDTO](#ErrorMessageDTO) ] |
| 500 | Internal Error | [ [ErrorMessageDTO](#ErrorMessageDTO) ] |

### /loan/{loanId}

#### GET
##### Description:

Delete Loan By Id.

##### Parameters

| Name | Located in | Description | Required | Schema |
| ---- | ---------- | ----------- | -------- | ---- |
| loanId | path |  | Yes | string |

##### Responses

| Code | Description | Schema |
| ---- | ----------- | ------ |
| 200 | Successful | [ [MessageDTO](#MessageDTO) ] |
| 400 | Bad Request | [ [ErrorMessageDTO](#ErrorMessageDTO) ] |
| 500 | Internal Error | [ [ErrorMessageDTO](#ErrorMessageDTO) ] |

### Models


#### RequestLoanDTO

| Name | Type | Description | Required |
| ---- | ---- | ----------- | -------- |
| id | string |  | No |
| monto | number |  | No |
| clienteId | string |  | No |
| fecha | string |  | No |
| estado | string |  | No |

#### ResponseLoanDTO

| Name | Type | Description | Required |
| ---- | ---- | ----------- | -------- |
| id | string |  | No |
| monto | number |  | No |
| clienteId | string |  | No |
| fecha | string |  | No |
| estado | string |  | No |
| pagoFinal | number |  | No |
| tasaInteres | integer |  | No |

#### RequestClientDTO

| Name | Type | Description | Required |
| ---- | ---- | ----------- | -------- |
| id | string |  | No |
| email | string |  | No |
| nombre | string |  | No |
| edad | integer |  | No |
| tipoCliente | string |  | No |

#### ResponseClientDTO

| Name | Type | Description | Required |
| ---- | ---- | ----------- | -------- |
| id | string |  | No |
| email | string |  | No |
| nombre | string |  | No |
| edad | integer |  | No |
| tipoCliente | string |  | No |
| descuento | boolean |  | No |

#### MessageDTO

| Name | Type | Description | Required |
| ---- | ---- | ----------- | -------- |
| message | string |  | No |

#### ErrorMessageDTO

| Name | Type | Description | Required |
| ---- | ---- | ----------- | -------- |
| message | string |  | No |
