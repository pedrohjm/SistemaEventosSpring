# Instruções para JasperSoft Studio - Sistema de Eventos 361

## 📋 O que você precisa fazer:

### 1. Baixar e Instalar o JasperSoft Studio
- Acesse: https://community.jaspersoft.com/project/jaspersoft-studio
- Baixe a versão Community (gratuita)
- Instale no seu computador

### 2. Abrir os Templates no JasperSoft Studio

#### Relatório Principal:
- Abra o arquivo: `src/main/resources/relatorios/relatorio_eventos.jrxml`
- Este é o relatório principal que mostra os eventos

#### Sub-relatório:
- Abra o arquivo: `src/main/resources/relatorios/sub_relatorio_participantes.jrxml`
- Este sub-relatório mostra os participantes de cada evento

### 3. Compilar os Relatórios (.jrxml → .jasper)

No JasperSoft Studio, para cada arquivo `.jrxml`:

1. **Abra o arquivo** no JasperSoft Studio
2. **Clique com botão direito** no arquivo no Explorer do Studio
3. **Selecione "Compile Report"**
4. Isso criará um arquivo `.jasper` na mesma pasta

**IMPORTANTE**: Os arquivos `.jasper` devem estar na pasta `src/main/resources/relatorios/` junto com os `.jrxml`

### 4. Testar o Projeto

#### Compilar as dependências:
```bash
# Se você tem Maven instalado:
mvn clean install

# Se você tem Docker (alternativa):
# Use o docker-compose.yml do projeto
```

#### Executar o projeto:
1. Execute a aplicação Spring Boot
2. Faça login no sistema
3. No menu lateral, clique em "Relatório PDF"
4. O PDF será gerado e aberto no navegador

### 5. Estrutura do Relatório

#### Relatório Principal (`relatorio_eventos.jrxml`):
- **Título**: Sistema de Eventos 361
- **Colunas**: Código, Nome do Evento, Local, Data, Capacidade, Organizador
- **Sub-relatório**: Lista de participantes para cada evento

#### Sub-relatório (`sub_relatorio_participantes.jrxml`):
- **Dados**: Código do participante, Nome, Email
- **Formatação**: Tabela com bordas e espaçamento

### 6. Funcionalidades Implementadas

✅ **Relatório Principal com Sub-relatório**
- Eventos listados com seus participantes
- Layout profissional com bordas e formatação

✅ **Integração com Sistema**
- Link no menu lateral
- Dados dinâmicos do banco de dados
- Atualização automática quando novos eventos/participantes são criados

✅ **Funcionalidades do PDF**
- Cabeçalho com título e data de geração
- Paginação automática
- Formatação de datas (dd/MM/yyyy)
- Sub-relatório aninhado

### 7. Dados Incluídos no Relatório

O relatório inclui TODOS os dados que você solicitou:
- **Eventos criados** pelos palestrantes
- **Participantes** que se inscreveram nos eventos
- **Usuários cadastrados** (organizadores e participantes)
- **Data de atualização** automática

### 8. Solução de Problemas

#### Se o PDF não for gerado:
1. Verifique se os arquivos `.jasper` existem
2. Confirme que compilou ambos os relatórios no JasperSoft Studio
3. Verifique se há dados no banco (eventos e participantes)

#### Se aparecer erro de dependências:
1. As dependências JasperReports já foram adicionadas ao `pom.xml`
2. Execute `mvn clean install` para baixar as dependências

### 9. Personalização (Opcional)

Você pode editar os relatórios no JasperSoft Studio para:
- Alterar cores e fontes
- Adicionar logos ou imagens
- Modificar o layout das colunas
- Incluir gráficos ou estatísticas

### 10. Testando o Sistema Completo

1. **Faça login** como PALESTRANTE
2. **Cadastre eventos** (vai aparecer no relatório)
3. **Faça login** como PARTICIPANTE  
4. **Inscreva-se nos eventos** (vai aparecer no sub-relatório)
5. **Clique em "Relatório PDF"** no menu
6. **Visualize** todos os dados no PDF gerado

## 🎉 Pronto!

Seu sistema agora tem um relatório PDF completo com sub-relatório, exatamente como solicitado! O relatório mostra todos os eventos, seus organizadores e todos os participantes inscritos em cada evento.
