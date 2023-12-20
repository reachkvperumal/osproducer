# osproducer
```
<Configuration status="WARN" monitorInterval="30">
    <Properties>
        <Property name="LOG_PATTERN">%d{ISO8601} %-5p [%t] %c{2} - %m%n</Property>
    </Properties>

    <Appenders>
        <Console name="Console" target="SYSTEM_OUT" follow="true">
            <PatternLayout pattern="${LOG_PATTERN}" />
        </Console>
    </Appenders>

    <Loggers>
        <!-- Logger name="com.kv.os">
            <AppenderRef ref="Console" />
        </Logger -->
        <Root level="info">
            <AppenderRef ref="Console" />
        </Root>
    </Loggers>
</Configuration>
```