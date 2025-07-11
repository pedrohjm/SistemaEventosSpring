@echo off
echo.
echo ==========================================
echo     SISTEMA DE EVENTOS 361 - SETUP
echo ==========================================
echo.

echo [1/3] Verificando Java...
java -version
if errorlevel 1 (
    echo ERRO: Java nao encontrado! Instale o Java 21 primeiro.
    pause
    exit /b 1
)

echo.
echo [2/3] Verificando Maven...
call mvn -version >nul 2>&1
if errorlevel 1 (
    echo AVISO: Maven nao encontrado no PATH.
    echo.
    echo Opcoes para compilar o projeto:
    echo 1. Instalar Maven: https://maven.apache.org/download.cgi
    echo 2. Usar IDE como IntelliJ IDEA ou Eclipse
    echo 3. Usar Docker com: docker-compose up
    echo.
    echo Para continuar sem Maven, pressione qualquer tecla...
    pause >nul
) else (
    echo Maven encontrado! Compilando projeto...
    call mvn clean compile
    if errorlevel 1 (
        echo ERRO: Falha na compilacao!
        pause
        exit /b 1
    )
    echo Compilacao concluida com sucesso!
)

echo.
echo [3/3] Verificando dependencias do JasperReports...
echo.
echo As seguintes dependencias foram adicionadas ao pom.xml:
echo - net.sf.jasperreports:jasperreports:6.21.3
echo - net.sf.jasperreports:jasperreports-fonts:6.21.3
echo.

echo ==========================================
echo           PROXIMOS PASSOS:
echo ==========================================
echo.
echo 1. Baixar JasperSoft Studio:
echo    https://community.jaspersoft.com/project/jaspersoft-studio
echo.
echo 2. Abrir e compilar os arquivos .jrxml:
echo    - src/main/resources/relatorios/relatorio_eventos.jrxml
echo    - src/main/resources/relatorios/sub_relatorio_participantes.jrxml
echo.
echo 3. Executar o projeto:
echo    - Usar sua IDE favorita
echo    - Ou: mvn spring-boot:run
echo    - Ou: docker-compose up
echo.
echo 4. Testar o relatorio:
echo    - Fazer login no sistema
echo    - Clicar em "Relatorio PDF" no menu lateral
echo.
echo Leia o arquivo INSTRUCOES_JASPER_STUDIO.md para detalhes!
echo.
echo ==========================================
pause
