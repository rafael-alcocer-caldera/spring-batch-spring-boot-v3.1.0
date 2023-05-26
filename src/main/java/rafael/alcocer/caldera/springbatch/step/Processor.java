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
package rafael.alcocer.caldera.springbatch.step;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

/**
 * According to the chunk size (commit-interval) value, this will define the
 * number of items to process before pass to the Writer.
 * 
 * @author Rafael Alcocer Caldera
 * @version 1.0
 *
 */
public class Processor implements ItemProcessor<String, String> {

    private static Logger logger = LoggerFactory.getLogger(Processor.class);

    @Override
    public String process(String item) throws Exception {
        String itemProcessed = item.toUpperCase();

        logger.info("##### Processor...process()...item before: " + item);
        logger.info("##### Processor...process()...item after: " + itemProcessed);

        return itemProcessed;
    }

}