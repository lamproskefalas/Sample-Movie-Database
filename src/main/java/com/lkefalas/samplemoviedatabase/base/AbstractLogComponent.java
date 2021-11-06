package com.lkefalas.samplemoviedatabase.base;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Abstract class used to provide logging functionality to all components.
 */
public abstract class AbstractLogComponent {
	protected Logger logger = LoggerFactory.getLogger(getClass());
}