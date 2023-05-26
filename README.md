## Synopsis

The project is a Spring Boot Application version 3.1.0 that uses Spring Batch without XML configuration files. 

This is the same project as this [Spring Batch without XML](https://github.com/rafael-alcocer-caldera/spring-batch-without-xml) but updated to the last version of Spring Boot. Version 3.1.0. Up to date May-2023.

It uses HSQLDB as a repository.

The way to process a Step is Chunk Oriented Processing.

Refers to reading the data one at a time, and creating 'chunks' that will be
written out, within a transaction boundary.

One item is read in from an ItemReader, handed to an ItemProcessor, and
aggregated to a List.

Once the number of items read equals the commit interval, the entire chunk is
written out via the ItemWriter, and then the transaction is committed.

This commit interval is equals to the chunk size.
This is configurable through the application.properties. 

This application only reads a String array of lowercase letters ("a", "b", "c", "d", "e", "f", "g", "h", "i", "j").

Process the letters to uppercase.

Writes the letters in chunks of 2.

## Motivation

I wanted to have an easy example about Spring Batch using Chunk Oriented Processing without XML configuration files.

## Tests

In Eclipse use: 

Run As -> Spring Boot App

or

Run As -> Java Application

## Output Log Example

```

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::                (v3.1.0)

2023-05-26T13:56:26.054-06:00  INFO 41847 --- [           main] r.a.c.s.SpringBatchSpringBootApplication : Starting SpringBatchSpringBootApplication using Java 17.0.7 with PID 41847 (/Users/rac/Documents/GitHub/spring-batch-spring-boot-v3.1.0/target/classes started by rac in /Users/rac/Documents/GitHub/spring-batch-spring-boot-v3.1.0)
2023-05-26T13:56:26.056-06:00  INFO 41847 --- [           main] r.a.c.s.SpringBatchSpringBootApplication : No active profile set, falling back to 1 default profile: "default"
2023-05-26T13:56:26.342-06:00  INFO 41847 --- [           main] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Starting...
2023-05-26T13:56:26.344-06:00  WARN 41847 --- [           main] c.zaxxer.hikari.util.DriverDataSource    : Registered driver with driverClassName=org.hsqldb.jdbcDriver was not found, trying direct instantiation.
2023-05-26T13:56:26.473-06:00  INFO 41847 --- [           main] com.zaxxer.hikari.pool.PoolBase          : HikariPool-1 - Driver does not support get/set network timeout for connections. (característica no soportada)
2023-05-26T13:56:26.474-06:00  INFO 41847 --- [           main] com.zaxxer.hikari.pool.HikariPool        : HikariPool-1 - Added connection org.hsqldb.jdbc.JDBCConnection@4cd1c1dc
2023-05-26T13:56:26.474-06:00  INFO 41847 --- [           main] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Start completed.
2023-05-26T13:56:26.587-06:00  INFO 41847 --- [           main] r.a.c.s.SpringBatchSpringBootApplication : Started SpringBatchSpringBootApplication in 0.688 seconds (process running for 0.878)
2023-05-26T13:56:26.588-06:00  INFO 41847 --- [           main] o.s.b.a.b.JobLauncherApplicationRunner   : Running default command line with: []
2023-05-26T13:56:26.606-06:00  INFO 41847 --- [           main] o.s.b.c.l.support.SimpleJobLauncher      : Job: [SimpleJob: [name=job]] launched with the following parameters: [{}]
2023-05-26T13:56:26.614-06:00  INFO 41847 --- [           main] o.s.batch.core.job.SimpleStepHandler     : Executing step: [step1]
2023-05-26T13:56:26.621-06:00  INFO 41847 --- [           main] r.a.caldera.springbatch.step.Reader      : ##### Reader...read()...item: a, count: 1
2023-05-26T13:56:26.622-06:00  INFO 41847 --- [           main] r.a.caldera.springbatch.step.Reader      : ##### Reader...read()...item: b, count: 2
2023-05-26T13:56:26.623-06:00  INFO 41847 --- [           main] r.a.caldera.springbatch.step.Processor   : ##### Processor...process()...item before: a
2023-05-26T13:56:26.623-06:00  INFO 41847 --- [           main] r.a.caldera.springbatch.step.Processor   : ##### Processor...process()...item after: A
2023-05-26T13:56:26.623-06:00  INFO 41847 --- [           main] r.a.caldera.springbatch.step.Processor   : ##### Processor...process()...item before: b
2023-05-26T13:56:26.623-06:00  INFO 41847 --- [           main] r.a.caldera.springbatch.step.Processor   : ##### Processor...process()...item after: B
2023-05-26T13:56:26.623-06:00  INFO 41847 --- [           main] r.a.caldera.springbatch.step.Writer      : ##### Writer...write()...item: A
2023-05-26T13:56:26.623-06:00  INFO 41847 --- [           main] r.a.caldera.springbatch.step.Writer      : ##### Writer...write()...item: B
2023-05-26T13:56:26.623-06:00  INFO 41847 --- [           main] r.a.caldera.springbatch.step.Writer      : ##### Writer...write()...END
2023-05-26T13:56:26.625-06:00  INFO 41847 --- [           main] r.a.caldera.springbatch.step.Reader      : ##### Reader...read()...item: c, count: 3
2023-05-26T13:56:26.625-06:00  INFO 41847 --- [           main] r.a.caldera.springbatch.step.Reader      : ##### Reader...read()...item: d, count: 4
2023-05-26T13:56:26.625-06:00  INFO 41847 --- [           main] r.a.caldera.springbatch.step.Processor   : ##### Processor...process()...item before: c
2023-05-26T13:56:26.625-06:00  INFO 41847 --- [           main] r.a.caldera.springbatch.step.Processor   : ##### Processor...process()...item after: C
2023-05-26T13:56:26.625-06:00  INFO 41847 --- [           main] r.a.caldera.springbatch.step.Processor   : ##### Processor...process()...item before: d
2023-05-26T13:56:26.625-06:00  INFO 41847 --- [           main] r.a.caldera.springbatch.step.Processor   : ##### Processor...process()...item after: D
2023-05-26T13:56:26.625-06:00  INFO 41847 --- [           main] r.a.caldera.springbatch.step.Writer      : ##### Writer...write()...item: C
2023-05-26T13:56:26.625-06:00  INFO 41847 --- [           main] r.a.caldera.springbatch.step.Writer      : ##### Writer...write()...item: D
2023-05-26T13:56:26.625-06:00  INFO 41847 --- [           main] r.a.caldera.springbatch.step.Writer      : ##### Writer...write()...END
2023-05-26T13:56:26.626-06:00  INFO 41847 --- [           main] r.a.caldera.springbatch.step.Reader      : ##### Reader...read()...item: e, count: 5
2023-05-26T13:56:26.626-06:00  INFO 41847 --- [           main] r.a.caldera.springbatch.step.Reader      : ##### Reader...read()...item: f, count: 6
2023-05-26T13:56:26.626-06:00  INFO 41847 --- [           main] r.a.caldera.springbatch.step.Processor   : ##### Processor...process()...item before: e
2023-05-26T13:56:26.626-06:00  INFO 41847 --- [           main] r.a.caldera.springbatch.step.Processor   : ##### Processor...process()...item after: E
2023-05-26T13:56:26.626-06:00  INFO 41847 --- [           main] r.a.caldera.springbatch.step.Processor   : ##### Processor...process()...item before: f
2023-05-26T13:56:26.626-06:00  INFO 41847 --- [           main] r.a.caldera.springbatch.step.Processor   : ##### Processor...process()...item after: F
2023-05-26T13:56:26.626-06:00  INFO 41847 --- [           main] r.a.caldera.springbatch.step.Writer      : ##### Writer...write()...item: E
2023-05-26T13:56:26.626-06:00  INFO 41847 --- [           main] r.a.caldera.springbatch.step.Writer      : ##### Writer...write()...item: F
2023-05-26T13:56:26.626-06:00  INFO 41847 --- [           main] r.a.caldera.springbatch.step.Writer      : ##### Writer...write()...END
2023-05-26T13:56:26.627-06:00  INFO 41847 --- [           main] r.a.caldera.springbatch.step.Reader      : ##### Reader...read()...item: g, count: 7
2023-05-26T13:56:26.627-06:00  INFO 41847 --- [           main] r.a.caldera.springbatch.step.Reader      : ##### Reader...read()...item: h, count: 8
2023-05-26T13:56:26.627-06:00  INFO 41847 --- [           main] r.a.caldera.springbatch.step.Processor   : ##### Processor...process()...item before: g
2023-05-26T13:56:26.627-06:00  INFO 41847 --- [           main] r.a.caldera.springbatch.step.Processor   : ##### Processor...process()...item after: G
2023-05-26T13:56:26.627-06:00  INFO 41847 --- [           main] r.a.caldera.springbatch.step.Processor   : ##### Processor...process()...item before: h
2023-05-26T13:56:26.627-06:00  INFO 41847 --- [           main] r.a.caldera.springbatch.step.Processor   : ##### Processor...process()...item after: H
2023-05-26T13:56:26.627-06:00  INFO 41847 --- [           main] r.a.caldera.springbatch.step.Writer      : ##### Writer...write()...item: G
2023-05-26T13:56:26.627-06:00  INFO 41847 --- [           main] r.a.caldera.springbatch.step.Writer      : ##### Writer...write()...item: H
2023-05-26T13:56:26.627-06:00  INFO 41847 --- [           main] r.a.caldera.springbatch.step.Writer      : ##### Writer...write()...END
2023-05-26T13:56:26.629-06:00  INFO 41847 --- [           main] r.a.caldera.springbatch.step.Reader      : ##### Reader...read()...item: i, count: 9
2023-05-26T13:56:26.629-06:00  INFO 41847 --- [           main] r.a.caldera.springbatch.step.Reader      : ##### Reader...read()...item: j, count: 10
2023-05-26T13:56:26.629-06:00  INFO 41847 --- [           main] r.a.caldera.springbatch.step.Processor   : ##### Processor...process()...item before: i
2023-05-26T13:56:26.629-06:00  INFO 41847 --- [           main] r.a.caldera.springbatch.step.Processor   : ##### Processor...process()...item after: I
2023-05-26T13:56:26.629-06:00  INFO 41847 --- [           main] r.a.caldera.springbatch.step.Processor   : ##### Processor...process()...item before: j
2023-05-26T13:56:26.629-06:00  INFO 41847 --- [           main] r.a.caldera.springbatch.step.Processor   : ##### Processor...process()...item after: J
2023-05-26T13:56:26.629-06:00  INFO 41847 --- [           main] r.a.caldera.springbatch.step.Writer      : ##### Writer...write()...item: I
2023-05-26T13:56:26.629-06:00  INFO 41847 --- [           main] r.a.caldera.springbatch.step.Writer      : ##### Writer...write()...item: J
2023-05-26T13:56:26.629-06:00  INFO 41847 --- [           main] r.a.caldera.springbatch.step.Writer      : ##### Writer...write()...END
2023-05-26T13:56:26.632-06:00  INFO 41847 --- [           main] o.s.batch.core.step.AbstractStep         : Step: [step1] executed in 16ms
2023-05-26T13:56:26.636-06:00  INFO 41847 --- [           main] o.s.b.c.l.support.SimpleJobLauncher      : Job: [SimpleJob: [name=job]] completed with the following parameters: [{}] and the following status: [COMPLETED] in 23ms
2023-05-26T13:56:26.638-06:00  INFO 41847 --- [ionShutdownHook] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Shutdown initiated...
2023-05-26T13:56:26.651-06:00  INFO 41847 --- [ionShutdownHook] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Shutdown completed.

```

## Notes

If you Download ZIP, you'll get the file: "spring-batch-without-xml-master.zip".
If you have 7-Zip, choose extract here and you'll get the folder: "spring-batch-without-xml-master".

Within Eclipse you can choose Import... -> General -> Existing Projects into Workspace
Select root directory and browse the directory where you extracted the zip file.
Select "Copy projects into workspace".
You'll have the project imported with a lot of errors. Don't worry.
Go to menu and select Project -> Clean...
After select the project and clic to right button of the mouse to see the menu and select Maven -> Update Project...
Don't forget to have selected:
- Force Update of Snapshots/Releases
- Update project configuration from pom.xml
- Refresh workspace resources from local filesystem
- Clean projects
And clic OK.

Or

Within Eclipse you can choose Import... -> Maven -> Existing Maven Projects 
Root directory and browse.
If you have your folder in a different location of your workspace and
Select "Add project(s) to working set" -> spring-batch-without-xml (this will be the name of your project).
But if your folder is in your workspace the name will be: spring-batch-without-xml-master
This is cleaner that the other. No need to do other things.
But remember that you are not copying this folder into your workspace.

Or

Copy the folder into your workspace and change the name to  from spring-batch-without-xml-master to spring-batch-without-xml
Within Eclipse you can choose Import... -> Maven -> Existing Maven Projects 
Root directory and browse.
That's all.

## License

All work is under Apache 2.0 license
