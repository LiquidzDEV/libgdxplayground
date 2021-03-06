/*******************************************************************************
 * Copyright 2014 See AUTHORS file.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/

package io.piotrjastrzebski.playground.ecs.aitest.dog;

import com.artemis.annotations.Wire;
import com.badlogic.gdx.ai.btree.Task;
import com.badlogic.gdx.ai.btree.LeafTask;

/** @author implicit-invocation
 * @author davebaol */
@Wire(injectInherited = true)
public class MarkTask extends DogTask {

	@Override
	public Status execute () {
		Dog dog = getObject();
		if (dogSystem.standBesideATree(dog)) {
			dogSystem.markATree(dog);
			dog.setUrgent(false);
			return Status.SUCCEEDED;
		} else {
			return Status.FAILED;
		}
	}

	@Override
	protected Task<Dog> copyTo (Task<Dog> task) {
		super.copyTo(task);
		return task;
	}

}
