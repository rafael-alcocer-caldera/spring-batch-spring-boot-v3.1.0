/**
 * Copyright [2023] [RAFAEL ALCOCER CALDERA]
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * 	http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package rafael.alcocer.caldera.springbatch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Spring Batch Application with Spring Boot without using XML configuration
 * files.
 * 
 * The way to process a Step is Chunk Oriented Processing:
 * 
 * Refers to reading the data one at a time, and creating 'chunks' that will be
 * written out, within a transaction boundary.
 * 
 * One item is read in from an ItemReader, handed to an ItemProcessor, and
 * aggregated to a List.
 * 
 * Once the number of items read equals the commit interval, the entire chunk is
 * written out via the ItemWriter, and then the transaction is committed.
 * 
 * @author Rafael Alcocer Caldera
 * @version 1.0
 *
 */
@SpringBootApplication
public class SpringBatchSpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBatchSpringBootApplication.class, args);
    }
}
