
简书地址：http://www.jianshu.com/writer#/notebooks/11760359/notes/11836846

<img src="/img/MVC流程.jpg">

简单介绍下流程：浏览器发出请求，交给servlet，servlet收到请求后调用service组件进行处理，处理产生数据，数据从哪儿来，这里就调用dao,dao专门与数据库进行交互，数据一定要封装，在javabean组件中， servlet不适合作输出，转交给jsp,会把javabean存在域（request）里，jsp从request域里取出javabean的数据进行显示，将结果打给浏览器。

为了将来层与层之间进行维护，会在层与层之间定义接口，dao接口和service接口，service层对dao接口进行调用，dao层对dao接口进行实现，将来dao层换了，不影响service层。servlet接口也是一样的原理。