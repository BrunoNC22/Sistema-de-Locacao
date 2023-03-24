## Restrições e regras de negócio
Este sistema tem como objetivo permitir a locação de **maquinas e equipamentos** atraves de uma interface.
O sistema sera gerido pelo usuario **Funcionario**.
#
O sistema deve permitir ao Funcionario:

- O cadastro de novos funcionarios
- O cadastro de novos Clientes
- O cadastro de novos produtos
- A emissão de Pedidos
- A emissão de Boletos
- A possibilidade de editar Pedidos ja emitidos
- A possibilidade de buscar por: Clientes, Pedidos, Produtos e Boletos ja emitidos/cadastrados

## Restrições de atributos em geral
Restrições de cada atributo para cada classe do sistemna.
### - Funcionario
**nome:**
> Tipo: String <br />
> Descrição: nome completo do funcionário<br />
> Aceita nulo: não <br />
> permitido alteração futura: sim<br />
> Padrão (regex): nenhum <br />
> Mínimo de caracteres: 3<br />
> Máximo de caracteres: 30<br />
> Aceita espaço em branco: sim

**tel:**
> Tipo: String <br />
> Descrição: telefone para contato do funcionário<br />
> Aceita nulo: sim<br />
> permitido alteração futura: sim<br />
> Padrão (regex): (XX) XXXXX-XXXX<br />
> Mínimo de caracteres: 15 <br />
> Máximo de caracteres: 15 <br />
> Aceita espaço em branco: não

**senha:**
> Tipo: String <br />
> Descrição: senha usada pelo Funcionário para efetuar o login no sistema<br />
> Aceita nulo: não<br />
> permitido alteração futura: sim<br />
> Padrão (regex): nenhum<br />
> Mínimo de caracteres: 8<br />
> Máximo de caracteres: 20<br />
> Aceita espaço em branco: sim

### - Cliente
**nome:**
> Tipo: String <br />
> Descrição: nome completo do cliente<br />
> Aceita nulo: não<br />
> permitido alteração futura: sim<br />
> Padrão (regex): nenhum<br />
> Mínimo de caracteres: 3<br />
> Máximo de caracteres: 50<br />
> Aceita espaço em branco: sim

**tel:**
> Tipo: String <br />
> Descrição: telefone para contato do cliente<br />
> Aceita nulo: sim<br />
> Permitido alteração futura: sim <br />
> Padrão (regex): (XX) XXXXX-XXXX<br />
> Mínimo de caracteres: 15 <br />
> Máximo de caracteres: 15 <br />
> Aceita espaço em branco: não

**endereco:**
> Tipo: String <br />
> Descrição: endereço da residência do cliente<br />
> Aceita nulo: sim<br />
> permitido alteração futura: sim<br />
> Padrão (regex): nenhum<br />
> Mínimo de caracteres: 0<br />
> Máximo de caracteres: 30<br />
> Aceita espaço em branco: sim

**cpf:**
> Tipo: String <br />
> Descrição: preenchido caso o tipo do cliente seja pessoa fisica<br />
> Aceita nulo: sim<br />
> Permitido alteração futura: sim<br />
> Padrão (regex): XXX.XXX.XXX-XX<br />
> Mínimo de caracteres: 14<br />
> Máximo de caracteres: 14<br />
> Aceita espaço em branco: não

**cnpj:**
> Tipo: String <br />
> Descrição: preenchido caso o tipo do cliente seja pessoa jurídica<br />
> Aceita nulo: sim<br />
> Permitido alteração futura: sim<br />
> Padrão (regex): XX.XXX.XXX/XXXX-XX<br />
> Mínimo de caracteres: 18<br />
> Máximo de caracteres: 18<br />
> Aceita espaço em branco: não

**tipo:**
> Tipo: String <br />
> Descrição: PF para pessoa física ou PJ para pessoa jurídica<br />
> Aceita nulo: não<br />
> permitido alteração futura: sim<br />
> Padrão (regex): XX<br />
> Mínimo de caracteres: 2<br />
> Máximo de caracteres: 2<br />
> Aceita espaço em branco: não

**email**
> Tipo: String <br />
> Descrição: endereço de email do cliente<br />
> Aceita nulo: sim<br />
> permitido alteração futura: sim<br />
> Padrão (regex): padrão de E-mail<br />
> Mínimo de caracteres: 0<br />
> Máximo de caracteres: 30<br />
> Aceita espaço em branco: não

### - Pedido
**dataEmissao:**
> Tipo: Date <br />
> Formato: DD/MM/YYYY <br />
> Descrição: data que o contrato foi emitido <br />
> Aceita nulo: não<br />
> Permitido alteração futura: não

**horaEmissao:**
> Tipo: Time <br />
> Formato: HH:MM <br />
> Descrição: hora em que o contrato foi emitido. Gerado automaticamente pelo sistema<br />
> Aceita nulo: não<br />
> Permitido alteração futura: não

**periodo**
> Tipo: String <br />
> Descrição: data de inicio e previsão de fim de vigencia do contrato, podendo abranger x dias, x semanas ou no maximo 1 mes (30 dias)<br />
> Aceita nulo: não<br />
> permitido alteração futura: sim<br />
> Padrão (regex): (Date) DD/MM/YYYY até (Date) DD/MM/YYYY XX dias<br />
> Mínimo de caracteres: 20<br />
> Máximo de caracteres: 30<br />
> Aceita espaço em branco: não

**dataDevolucao**
> Tipo: Date <br />
> Formato: DD/MM/YYYY <br />
> Descrição: preenchido quando os produtos são devidamente devolvidos<br />
> Aceita nulo: sim<br />
> Permitido alteração futura: não

**horaDevolucao**
> Tipo: Time <br />
> Formato: HH:MM <br />
> Descrição: gerado automaticamente pelo sistema ao definir a variavel dataDevolucao<br />
> Aceita nulo: sim<br />
> Permitido alteração futura: não

**contrato:**
> Tipo: int 
> Descrição: atributo de classe. Cada pedido tem seu respectivo numero de contrato. Somado +1 após a emissão de um novo pedido<br />
> Aceita nulo: não<br />
> Permitido alteração futura: não<br />
> Padrão (regex): nenhum<br />
> Valor Mínimo: 0 <br />
> Valor Máximo: indefinido <br /> 


**endereco:**
> Tipo: String <br />
> Descrição: endereço onde o produto será destinado<br />
> Aceita nulo: sim<br />
> permitido alteração futura: sim<br />
> Padrão (regex): nenhum<br />
> Mínimo de caracteres: 0<br />
> Máximo de caracteres: 30<br />
> Aceita espaço em branco: sim

**valorTotal:**
> Tipo: float
> Descrição: valor da soma de todos os produtos no pedido<br />
> Aceita nulo: não<br />
> Permitido alteração futura: não<br />
> Padrão (regex): nenhum<br />
> Valor Mínimo: 0,00 <br />
> Valor Máximo: 999.999,99 <br /> 

### - Produto
**descricao:**
> Tipo: String <br />
> Descrição: nome do produto e possiveis detalhes como peso, tamanho e voltagem<br />
> Aceita nulo: não<br />
> permitido alteração futura: sim<br />
> Padrão (regex): nenhum<br />
> Mínimo de caracteres: 3<br />
> Máximo de caracteres: 30<br />
> Aceita espaço em branco: sim

**valorDia:**
> Tipo: float
> Descrição: valor do produto para cada dia de locação<br />
> Aceita nulo: não<br />
> Permitido alteração futura: sim<br />
> Padrão (regex): nenhum<br />
> Valor Mínimo: 0,00 <br />
> Valor Máximo: 999.999,99 <br /> 

**valorSemana:**
> Tipo: float
> Descrição: valor do produto para cada semana de locação<br />
> Aceita nulo: não<br />
> Permitido alteração futura: sim<br />
> Padrão (regex): nenhum<br />
> Valor Mínimo: 0,00 <br />
> Valor Máximo: 999.999,99 <br /> 

**valorMes:**
> Tipo: float
> Descrição: valor do produto para cada mes (30 dias) de locação<br />
> Aceita nulo: não<br />
> Permitido alteração futura: sim<br />
> Padrão (regex): nenhum<br />
> Valor Mínimo: 0,00 <br />
> Valor Máximo: 999.999,99 <br /> 

### - Boleto
**numeroDoBoleto:**
> Tipo: int 
> Descrição: atributo de classe, Cada boleto gerado tem seu respectivo numero de boleto. Somado +1 após emissão de um boleto<br />
> Aceita nulo: não<br />
> Permitido alteração futura: não<br />
> Padrão (regex): nenhum<br />
> Valor Mínimo: 0 <br />
> Valor Máximo: indefinido <br /> 

**dataEmissao:**
> Tipo: Date <br />
> Formato: DD/MM/YYYY <br />
> Descrição: data da emissão do boleto<br />
> Aceita nulo: <br />
> Permitido alteração futura: 

**dataPagamento:**
> Tipo: Date <br />
> Formato: DD/MM/YYYY <br />
> Descrição: data do pagamento do boleto<br />
> Aceita nulo: sim<br />
> Permitido alteração futura: sim

**valor:**
> Tipo: float
> Descrição: valor do boleto gerado a partir do seu respectivo Pedido<br />
> Aceita nulo: não<br />
> Permitido alteração futura: sim<br />
> Padrão (regex): nenhum<br />
> Valor Mínimo: 0,00 <br />
> Valor Máximo: 999.999,99 <br /> 

