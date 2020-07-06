package org.jboss.resteasy.util;

import java.util.ArrayList;

/**
 * Comment
 *
 * @author <a href="mailto:bill@jboss.org">Bill Burke</a>
 * @version $Revision$
 */
public class ThreadLocalStack<T> extends AbstractThreadLocalStack<T>
{
   private ThreadLocal<ArrayList<T>> local = new ThreadLocal<ArrayList<T>>();

   @Override
   protected ArrayList<T> getLocal()
   {
      return local.get();
   }

   @Override
   protected void setLocal(ArrayList<T> val)
   {
      local.set(val);
   }

}
