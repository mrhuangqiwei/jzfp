import App from './app';

export default [
    {
        path: '/',
        component: App,
        children: [
            {
                path:'/default',
                component:resolve=>require(['./default'],resolve),
                children:[
                    {
                        path: '/homePage',
                        component: resolve => require(['./homePage/homePage'],resolve),
                    },
                    {
                        path:'/',
                        component: resolve=>require(['./homePage/homePage'],resolve),   
                    },
                    {
                        path:'*',
                        redirect:'/'
                    }
                ]
            }, 
            {
                path: '*',
                component: resolve => require(['./default'],resolve),
                redirect:'/default'
            }
        ]
        
    }
];