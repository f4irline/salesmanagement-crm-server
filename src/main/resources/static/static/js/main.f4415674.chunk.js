(window.webpackJsonp=window.webpackJsonp||[]).push([[0],{30:function(e,t,a){"use strict";a.r(t),a.d(t,"print",function(){return n});var n=function(e,t,a){void 0!==a?console.log((new Date).toUTCString()," - [".concat(e,"]: [").concat(t,"], msg: ").concat(a)):console.log((new Date).toUTCString()," - [".concat(e,"]: [").concat(t,"]"))}},381:function(e,t,a){e.exports=a(830)},386:function(e,t,a){},388:function(e,t,a){},522:function(e,t,a){},524:function(e,t,a){},629:function(e,t,a){},801:function(e,t,a){},816:function(e,t,a){},818:function(e,t,a){},820:function(e,t,a){},823:function(e,t,a){},825:function(e,t,a){},827:function(e,t,a){},829:function(e,t,a){"use strict";a.r(t),a.d(t,"getDate",function(){return n});var n=function(e,t){var a;return console.log("getDate(date: ".concat(e,", value: ").concat(t,")")),a=null!=t?new Date(t):new Date,"monthFirst"===e&&a.setDate(1),"monthLast"===e&&(a.setDate(1),a.setMonth(a.getMonth()+1),a.setDate(a.getDate()-1)),a.toISOString().slice(0,10)}},830:function(e,t,a){"use strict";a.r(t);var n=a(1),i=a.n(n),r=a(31),s=a.n(r),l=(a(386),a(24)),o=a(25),c=a(27),m=a(26),d=a(28),h=a(833),u=a(834),p=a(831),v=a(136),g=a.n(v),E=a(361),b=a.n(E),y=a(21),f=a(17),C=a.n(f),D=(a(388),a(32)),N=a.n(D),O=a(135),j=a.n(O),k=a(68),S=a.n(k),w=a(52),L=a(18),I=a.n(L),T=a(33),x=a.n(T),W=function(e){function t(){var e;return Object(l.a)(this,t),(e=Object(c.a)(this,Object(m.a)(t).call(this))).state={date:(new Date).toISOString().split("T")[0],companyName:"",contactPerson:"",contactRole:"",phoneNumber:"",email:"",website:"",industry:"",notes:"",eventType:4},e.handleChange=function(t){e.setState(Object(w.a)({},t.target.name,t.target.value))},e.handleChange=e.handleChange.bind(Object(y.a)(Object(y.a)(e))),e}return Object(d.a)(t,e),Object(o.a)(t,[{key:"render",value:function(){return i.a.createElement("div",{className:"content-all"},i.a.createElement(C.a,{variant:"h5",className:"event-header"},"Liidi"),i.a.createElement("div",{className:"content-fields"},i.a.createElement(I.a,{name:"date",label:"P\xe4iv\xe4m\xe4\xe4r\xe4",type:"date",InputLabelProps:{shrink:!0},onChange:this.handleChange,className:"content-item",variant:"outlined",required:!0,value:this.state.date}),i.a.createElement(I.a,{name:"companyName",label:"Yrityksen nimi",onChange:this.handleChange,className:"content-item",variant:"outlined",required:!0}),i.a.createElement(I.a,{name:"industry",label:"Yrityksen toimiala",onChange:this.handleChange,className:"content-item",variant:"outlined"}),i.a.createElement(I.a,{name:"website",label:"Yrityksen kotisivu",onChange:this.handleChange,className:"content-item",variant:"outlined"})),i.a.createElement(C.a,{variant:"h5",className:"event-header"},"Yhteyshenkil\xf6:"),i.a.createElement("div",{className:"content-fields"},i.a.createElement(I.a,{name:"contactPerson",label:"Nimi",onChange:this.handleChange,className:"content-item",variant:"outlined",required:!0}),i.a.createElement(I.a,{name:"contactRole",label:"Rooli",onChange:this.handleChange,className:"content-item",variant:"outlined",required:!0}),i.a.createElement(I.a,{name:"email",label:"S\xe4hk\xf6posti",onChange:this.handleChange,className:"content-item",variant:"outlined"}),i.a.createElement(I.a,{name:"phoneNumber",label:"Puhelinnumero",onChange:this.handleChange,className:"content-item",variant:"outlined"})),i.a.createElement(C.a,{variant:"h5",className:"event-header"},"Lis\xe4tiedot:"),i.a.createElement("div",{className:"info-container"},i.a.createElement(I.a,{name:"notes",label:"Lis\xe4tiedot",onChange:this.handleChange,className:"content-item",variant:"outlined",multiline:!0,fullWidth:!0})),i.a.createElement(x.a,{variant:"contained",color:"primary",onClick:this.props.handleSend(this.state),size:"large",className:"button-save"},"Tallenna"))}}]),t}(n.Component),A=a(59),U=a.n(A),P=a(43),_=a.n(P),M=a(49),B=a.n(M),R=a(87),q=a.n(R),z=function(e){function t(e){var a;return Object(l.a)(this,t),(a=Object(c.a)(this,Object(m.a)(t).call(this,e))).state={date:(new Date).toISOString().split("T")[0],companyName:"",contactPerson:"",phoneNumber:"",email:"",notes:"",eventType:0},a.handleChange=function(e){a.setState(Object(w.a)({},e.target.name,e.target.value))},a.handleChange=a.handleChange.bind(Object(y.a)(Object(y.a)(a))),a}return Object(d.a)(t,e),Object(o.a)(t,[{key:"render",value:function(){return i.a.createElement("div",{className:"content-all"},i.a.createElement(C.a,{variant:"h5",className:"event-header"},"Yhteydenotto"),i.a.createElement("div",{className:"content-fields"},i.a.createElement(I.a,{name:"date",label:"P\xe4iv\xe4m\xe4\xe4r\xe4",type:"date",InputLabelProps:{shrink:!0},onChange:this.handleChange,className:"content-item",variant:"outlined",required:!0,value:this.state.date}),i.a.createElement(q.a,{className:"content-item"},i.a.createElement(_.a,{name:"companyName",displayEmpty:!0,value:this.state.companyName,onChange:this.handleChange,input:i.a.createElement(B.a,{name:"company",labelWidth:0}),required:!0},this.props.leadNames)),i.a.createElement(I.a,{name:"contactPerson",label:"Yhteyshenkil\xf6",onChange:this.handleChange,className:"content-item",variant:"outlined",required:!0}),i.a.createElement(I.a,{name:"phoneNumber",label:"Puhelinnumero",onChange:this.handleChange,className:"content-item",variant:"outlined"}),i.a.createElement(I.a,{name:"email",label:"S\xe4hk\xf6posti",onChange:this.handleChange,className:"content-item",variant:"outlined"})),i.a.createElement(C.a,{variant:"h5",className:"event-header"},"Lis\xe4tiedot:"),i.a.createElement("div",{className:"info-container"},i.a.createElement(I.a,{name:"notes",label:"Lis\xe4tiedot",onChange:this.handleChange,className:"content-item",variant:"outlined",multiline:!0,fullWidth:!0})),i.a.createElement(x.a,{variant:"contained",onClick:this.props.handleSend(this.state),color:"primary",size:"large",className:"button-save"},"Tallenna"))}}]),t}(n.Component),G=function(e){function t(){var e;return Object(l.a)(this,t),(e=Object(c.a)(this,Object(m.a)(t).call(this))).state={date:(new Date).toISOString().split("T")[0],companyName:"",place:"",notes:"",eventType:1},e.handleChange=function(t){e.setState(Object(w.a)({},t.target.name,t.target.value))},e.handleChange=e.handleChange.bind(Object(y.a)(Object(y.a)(e))),e}return Object(d.a)(t,e),Object(o.a)(t,[{key:"render",value:function(){return i.a.createElement("div",{className:"content-all"},i.a.createElement(C.a,{variant:"h5",className:"event-header"},"Tapaaminen"),i.a.createElement("div",{className:"secondary-content-fields"},i.a.createElement(I.a,{name:"date",label:"P\xe4iv\xe4m\xe4\xe4r\xe4",type:"date",InputLabelProps:{shrink:!0},onChange:this.handleChange,className:"content-item",variant:"outlined",required:!0,value:this.state.date}),i.a.createElement(_.a,{name:"companyName",value:this.state.companyName,onChange:this.handleChange,className:"content-item",input:i.a.createElement(B.a,{name:"company",labelWidth:0}),required:!0},this.props.leadNames),i.a.createElement(I.a,{name:"place",label:"Paikka",onChange:this.handleChange,className:"content-item",variant:"outlined",required:!0})),i.a.createElement(C.a,{variant:"h5",className:"event-header"},"Lis\xe4tiedot:"),i.a.createElement("div",{className:"info-container"},i.a.createElement(I.a,{name:"notes",label:"Lis\xe4tiedot",onChange:this.handleChange,className:"content-item",variant:"outlined",multiline:!0,fullWidth:!0})),i.a.createElement(x.a,{variant:"contained",onClick:this.props.handleSend(this.state),size:"large",className:"button-save",color:"primary"},"Tallenna"))}}]),t}(n.Component),K=function(e){function t(){var e;return Object(l.a)(this,t),(e=Object(c.a)(this,Object(m.a)(t).call(this))).state={date:(new Date).toISOString().split("T")[0],companyName:"",sum:0,notes:"",eventType:3},e.handleChange=function(t){e.setState(Object(w.a)({},t.target.name,t.target.value))},e.handleChange=e.handleChange.bind(Object(y.a)(Object(y.a)(e))),e}return Object(d.a)(t,e),Object(o.a)(t,[{key:"render",value:function(){return i.a.createElement("div",{className:"content-all"},i.a.createElement(C.a,{variant:"h5",className:"event-header"},"Myynti"),i.a.createElement("div",{className:"secondary-content-fields"},i.a.createElement(I.a,{name:"date",label:"P\xe4iv\xe4m\xe4\xe4r\xe4",type:"date",InputLabelProps:{shrink:!0},onChange:this.handleChange,className:"content-item",variant:"outlined",required:!0,value:this.state.date}),i.a.createElement(_.a,{name:"companyName",label:"Yritys",value:this.state.companyName,onChange:this.handleChange,className:"content-item",input:i.a.createElement(B.a,{name:"company",labelWidth:0}),required:!0},this.props.leadNames),i.a.createElement(I.a,{name:"sum",label:"Summa",onChange:this.handleChange,className:"content-item",variant:"outlined",type:"number",required:!0})),i.a.createElement(C.a,{variant:"h5",className:"event-header"},"Lis\xe4tiedot:"),i.a.createElement("div",{className:"info-container"},i.a.createElement(I.a,{name:"notes",label:"Lis\xe4tiedot",onChange:this.handleChange,className:"content-item",variant:"outlined",multiline:!0,fullWidth:!0})),i.a.createElement(x.a,{variant:"contained",onClick:this.props.handleSend(this.state),color:"primary",size:"large",className:"button-save"},"Tallenna"))}}]),t}(n.Component),V=function(e){function t(){var e;return Object(l.a)(this,t),(e=Object(c.a)(this,Object(m.a)(t).call(this))).state={date:(new Date).toISOString().split("T")[0],companyName:"",sum:0,notes:"",eventType:2},e.handleChange=function(t){e.setState(Object(w.a)({},t.target.name,t.target.value))},e.handleChange=e.handleChange.bind(Object(y.a)(Object(y.a)(e))),e}return Object(d.a)(t,e),Object(o.a)(t,[{key:"render",value:function(){return i.a.createElement("div",{className:"content-all"},i.a.createElement(C.a,{variant:"h5",className:"event-header"},"Tarjous"),i.a.createElement("div",{className:"secondary-content-fields"},i.a.createElement(I.a,{name:"date",label:"P\xe4iv\xe4m\xe4\xe4r\xe4",type:"date",InputLabelProps:{shrink:!0},onChange:this.handleChange,className:"content-item",variant:"outlined",required:!0,value:this.state.date}),i.a.createElement(_.a,{name:"companyName",value:this.state.companyName,onChange:this.handleChange,className:"content-item",input:i.a.createElement(B.a,{name:"company",labelWidth:0}),required:!0},this.props.leadNames),i.a.createElement(I.a,{name:"sum",label:"Summa",onChange:this.handleChange,className:"content-item",variant:"outlined",type:"number",required:!0})),i.a.createElement(C.a,{variant:"h5",className:"event-header"},"Lis\xe4tiedot:"),i.a.createElement("div",{className:"info-container"},i.a.createElement(I.a,{name:"notes",label:"Lis\xe4tiedot",onChange:this.handleChange,className:"content-item",variant:"outlined",multiline:!0,fullWidth:!0})),i.a.createElement(x.a,{variant:"contained",onClick:this.props.handleSend(this.state),color:"primary",size:"large",className:"button-save"},"Tallenna"))}}]),t}(n.Component),H=a(88),Y=a.n(H),F=a(142),J=a.n(F);J.a.defaults.xsrfCookieName="csrftoken",J.a.defaults.xsrfHeaderName="X-CSRFToken";var X=document.cookie.match(new RegExp("XSRF-TOKEN=([^;]+)"))[1],$=J.a.create({baseURL:"https://vc-system-server.herokuapp.com/api",headers:{"X-XSRF-TOKEN":X}}),Q=function(e){function t(){var e,a;Object(l.a)(this,t);for(var n=arguments.length,i=new Array(n),r=0;r<n;r++)i[r]=arguments[r];return(a=Object(c.a)(this,(e=Object(m.a)(t)).call.apply(e,[this].concat(i)))).state={selectedValue:"",leads:[],leadNames:[],labelWidth:0},a.updateData=function(){a.props.updateUserData(),a.props.updateLeaderBoards(),a.props.updateCompanyGraph()},a.handleSend=function(e){return function(t){if(4===e.eventType)$.post("/leads/add",e).then(function(e){return console.log(e)}).then(a.props.updateLeads);else{var n=a.findLeadId(e);$.post("events/add/".concat(a.props.userId,"/").concat(n),e).then(function(e){return console.log(e)}).then(a.updateData.bind(Object(y.a)(Object(y.a)(a))))}}},a.handleChange=function(e){a.setState({selectedValue:e.target.value})},a}return Object(d.a)(t,e),Object(o.a)(t,[{key:"componentDidMount",value:function(){var e=this;this.setState({leads:this.props.leads},function(){var t=e.state.leads.map(function(e){return i.a.createElement(Y.a,{key:e.companyName,value:e.companyName},e.companyName)});e.setState({leadNames:t})})}},{key:"findLeadId",value:function(e){var t=!0,a=!1,n=void 0;try{for(var i,r=this.state.leads[Symbol.iterator]();!(t=(i=r.next()).done);t=!0){var s=i.value;if(s.companyName===e.companyName)return s.leadId}}catch(l){a=!0,n=l}finally{try{t||null==r.return||r.return()}finally{if(a)throw n}}}},{key:"render",value:function(){var e=null;return"lead"===this.state.selectedValue?e=i.a.createElement(W,{handleSend:this.handleSend.bind(this)}):"contact"===this.state.selectedValue?e=i.a.createElement(z,{handleSend:this.handleSend.bind(this),leadNames:this.state.leadNames}):"meeting"===this.state.selectedValue?e=i.a.createElement(G,{handleSend:this.handleSend.bind(this),leadNames:this.state.leadNames}):"sales"===this.state.selectedValue?e=i.a.createElement(K,{handleSend:this.handleSend.bind(this),leadNames:this.state.leadNames}):"offer"===this.state.selectedValue&&(e=i.a.createElement(V,{handleSend:this.handleSend.bind(this),leadNames:this.state.leadNames})),i.a.createElement("div",{className:"ModalContent",tabIndex:-1},i.a.createElement(N.a,null,i.a.createElement(C.a,{variant:"h4",gutterBottom:!0,className:"controls-header"},"Lis\xe4\xe4:"),i.a.createElement("div",null,i.a.createElement(j.a,{row:!0,name:"radioGroup",value:this.state.value,onChange:this.handleChange.bind(this),className:"controls-wrapper"},i.a.createElement(U.a,{value:"lead",control:i.a.createElement(S.a,null),label:"Liidi"}),i.a.createElement(U.a,{value:"contact",control:i.a.createElement(S.a,null),label:"Yhteydenotto"}),i.a.createElement(U.a,{value:"meeting",control:i.a.createElement(S.a,null),label:"Tapaaminen"}),i.a.createElement(U.a,{value:"offer",control:i.a.createElement(S.a,null),label:"Tarjous"}),i.a.createElement(U.a,{value:"sales",control:i.a.createElement(S.a,null),label:"Myynti"}))),i.a.createElement("div",{className:"content-wrapper"},e)))}}]),t}(n.Component),Z=a(66),ee=a.n(Z),te=(a(522),a(23)),ae=a.n(te),ne=a(39),ie=a.n(ne),re=(a(524),a(42)),se=a(29),le=a(30),oe=function(e){function t(){var e,a;Object(l.a)(this,t);for(var n=arguments.length,i=new Array(n),r=0;r<n;r++)i[r]=arguments[r];return(a=Object(c.a)(this,(e=Object(m.a)(t)).call.apply(e,[this].concat(i)))).state={user:a.props.user,userData:a.props.userData},a}return Object(d.a)(t,e),Object(o.a)(t,[{key:"render",value:function(){Object(le.print)("UserData","render");var e=this.props.classes;return i.a.createElement(ae.a,{item:!0,xs:12,lg:5,className:"UserData",style:{minHeight:"46vh"}},i.a.createElement(C.a,{variant:"h2",classes:{root:e.header}},"Hei, ",this.state.user.userFirst),i.a.createElement(C.a,{variant:"h5",classes:{root:e.login}},"Sis\xe4\xe4nkirjautunut viimeksi: ",this.state.user.lastLogin),i.a.createElement(N.a,{elevation:5,classes:{root:e.paper}},i.a.createElement("div",null,i.a.createElement(se.List,null,i.a.createElement(se.ListItem,{classes:{root:e.listItem}},i.a.createElement(ae.a,{item:!0,xs:6},i.a.createElement(se.ListItemText,{primary:"Hit Rate %:"})),i.a.createElement(ae.a,{item:!0,xs:6},i.a.createElement(se.ListItemText,{primary:this.state.userData.hit_rate}))),i.a.createElement(ie.a,{variant:"middle"}),i.a.createElement(se.ListItem,{classes:{root:e.listItem}},i.a.createElement(ae.a,{item:!0,xs:6},i.a.createElement(se.ListItemText,{primary:"Keskim. myynti:"})),i.a.createElement(ae.a,{item:!0,xs:6},i.a.createElement(se.ListItemText,{primary:this.state.userData.avg_sales}))),i.a.createElement(ie.a,{variant:"middle"}),i.a.createElement(se.ListItem,{classes:{root:e.listItem}},i.a.createElement(ae.a,{item:!0,xs:6},i.a.createElement(se.ListItemText,{primary:"Kokonaismyynti:"})),i.a.createElement(ae.a,{item:!0,xs:6},i.a.createElement(se.ListItemText,{primary:this.state.userData.total_sales}))),i.a.createElement(ie.a,{variant:"middle"}),i.a.createElement(se.ListItem,{classes:{root:e.listItem}},i.a.createElement(ae.a,{item:!0,xs:6},i.a.createElement(se.ListItemText,{primary:"Yhteydenotot:"})),i.a.createElement(ae.a,{item:!0,xs:6},i.a.createElement(se.ListItemText,{primary:this.state.userData.contacts_amount}))),i.a.createElement(ie.a,{variant:"middle"}),i.a.createElement(se.ListItem,{classes:{root:e.listItem}},i.a.createElement(ae.a,{item:!0,xs:6},i.a.createElement(se.ListItemText,{primary:"Tapaamiset:"})),i.a.createElement(ae.a,{item:!0,xs:6},i.a.createElement(se.ListItemText,{primary:this.state.userData.meetings_amount}))),i.a.createElement(ie.a,{variant:"middle"}),i.a.createElement(se.ListItem,{classes:{root:e.listItem}},i.a.createElement(ae.a,{item:!0,xs:6},i.a.createElement(se.ListItemText,{primary:"Tarjoukset:"})),i.a.createElement(ae.a,{item:!0,xs:6},i.a.createElement(se.ListItemText,{primary:this.state.userData.offers_amount}))),i.a.createElement(ie.a,{variant:"middle"}),i.a.createElement(se.ListItem,{classes:{root:e.listItem}},i.a.createElement(ae.a,{item:!0,xs:6},i.a.createElement(se.ListItemText,{primary:"Sopimukset:"})),i.a.createElement(ae.a,{item:!0,xs:6},i.a.createElement(se.ListItemText,{primary:this.state.userData.sales_amount}))),i.a.createElement(ie.a,{variant:"middle"}),i.a.createElement(se.ListItem,{classes:{root:e.listItem}},i.a.createElement(ae.a,{item:!0,xs:6},i.a.createElement(se.ListItemText,{primary:"Myynnin tavoite:"})),i.a.createElement(ae.a,{item:!0,xs:6},i.a.createElement(se.ListItemText,{primary:this.state.user.goal})))))))}}]),t}(n.Component),ce=Object(re.withStyles)({itemContainer:{height:"100%"},listItem:{padding:"0.5vh 1vw"},paper:{margin:"1vw",padding:"0.5vw"},header:{margin:"1vh 0.5vw 0 0.5vw",padding:"0 0.5vw",textTransform:"uppercase",fontWeight:800},login:{margin:"0 1vw",padding:"0 1vw"}})(oe),me=(a(629),a(44)),de=function(e){function t(){var e,a;Object(l.a)(this,t);for(var n=arguments.length,i=new Array(n),r=0;r<n;r++)i[r]=arguments[r];return(a=Object(c.a)(this,(e=Object(m.a)(t)).call.apply(e,[this].concat(i)))).state={height:0,width:0},a}return Object(d.a)(t,e),Object(o.a)(t,[{key:"componentDidMount",value:function(){var e=this.chartWrapper.clientHeight,t=this.chartWrapper.clientWidth;this.setState({height:e,width:t}),window.addEventListener("resize",this.checkWindowSize.bind(this)),Object(le.print)("UserGraph","componentDidMount","width: ".concat(t,", height: ").concat(e))}},{key:"checkWindowSize",value:function(){try{var e=this.chartWrapper.clientHeight,t=this.chartWrapper.clientWidth;e===this.state.height&&t===this.state.width||this.setState({height:e,width:t})}catch(a){Object(le.print)("UserGraph","checkWindowSize","Reloading Div")}}},{key:"render",value:function(){var e=this;Object(le.print)("UserGraph","render");var t=5,a=this.props.goal-this.props.sales,n=[{name:"Group A",value:this.props.sales}];a>0?n.push({name:"Group B",value:a}):(a=0,t=0);var r=["#D72322","#222C35"];return i.a.createElement(ae.a,{item:!0,xs:12,lg:5,className:"UserGraph",style:{minHeight:"46vh"}},i.a.createElement("div",{className:"chart-header"},i.a.createElement(C.a,{variant:"h2",style:{fontWeight:800}},"TAVOITTEESI")),i.a.createElement("div",{className:"chart-wrapper",ref:function(t){return e.chartWrapper=t}},i.a.createElement(me.g,{width:this.state.width,height:this.state.height,onMouseEnter:this.onPieEnter},i.a.createElement(me.f,{data:n,innerRadius:"60%",outerRadius:"80%",paddingAngle:t,dataKey:"value",label:!0},n.map(function(e,t){return i.a.createElement(me.b,{key:"cell-".concat(t),fill:r[t%r.length]})})))))}}]),t}(n.PureComponent),he=(a(801),function(e){function t(){return Object(l.a)(this,t),Object(c.a)(this,Object(m.a)(t).apply(this,arguments))}return Object(d.a)(t,e),Object(o.a)(t,[{key:"render",value:function(){var e=this.props,t=e.x,a=e.y,n=e.payload;return i.a.createElement("g",{transform:"translate(".concat(t,",").concat(a,")")},i.a.createElement("text",{x:0,y:0,dy:16,textAnchor:"end",fill:"#666",transform:"rotate(-35)"},n.value))}}]),t}(n.PureComponent)),ue=function(e){function t(){var e,a;Object(l.a)(this,t);for(var n=arguments.length,i=new Array(n),r=0;r<n;r++)i[r]=arguments[r];return(a=Object(c.a)(this,(e=Object(m.a)(t)).call.apply(e,[this].concat(i)))).state={name:a.props.name,user:{},height:0,width:0,startDate:a.props.companyDates[0],endDate:a.props.companyDates[1],data:a.props.companyData},a.onChange=a.onChange.bind(Object(y.a)(Object(y.a)(a))),a}return Object(d.a)(t,e),Object(o.a)(t,[{key:"componentDidMount",value:function(){var e=this.chartWrapper.clientHeight,t=this.chartWrapper.clientWidth;this.setState({height:e,width:t}),window.addEventListener("resize",this.checkWindowSize.bind(this)),Object(le.print)("UserGraph","componentDidMount","width: ".concat(t,", height: ").concat(e))}},{key:"checkWindowSize",value:function(){try{var e=this.chartWrapper.clientHeight,t=this.chartWrapper.clientWidth;e===this.state.height&&t===this.state.width||this.setState({height:e,width:t})}catch(a){Object(le.print)("CompanyGraph","checkWindowSize","Reloading Div")}}},{key:"onChange",value:function(e){var t=this;Object(le.print)("CompanyGraph","onChange");var a=e.target.value;switch(e.target.id){case"startDate":this.setState({startDate:new Date(a).toISOString().slice(0,10)},function(){t.props.changeDate(t.state.startDate,t.state.endDate)});break;case"endDate":this.setState({endDate:new Date(a).toISOString().slice(0,10)},function(){t.props.changeDate(t.state.startDate,t.state.endDate)})}}},{key:"render",value:function(){var e=this;return Object(le.print)("CompanyGraph","render"),i.a.createElement(ae.a,{item:!0,xs:12,lg:11,className:"CompanyGraph",style:{minHeight:"46vh"}},i.a.createElement("div",{className:"company-chart-header"},i.a.createElement(C.a,{variant:"h2",style:{fontWeight:800}},"YRITYKSEN TAVOITE")),i.a.createElement("div",{className:"company-chart-wrapper",ref:function(t){return e.chartWrapper=t}},i.a.createElement(I.a,{className:"date",id:"startDate",label:"Aloitus p\xe4iv\xe4m\xe4\xe4r\xe4",type:"date",defaultValue:this.state.startDate,style:{margin:0},InputLabelProps:{shrink:!0},onChange:this.onChange}),i.a.createElement(I.a,{className:"date",id:"endDate",label:"Lopetus p\xe4iv\xe4m\xe4\xe4r\xe4",type:"date",defaultValue:this.state.endDate,style:{margin:0},InputLabelProps:{shrink:!0},onChange:this.onChange}),i.a.createElement(me.e,{width:this.state.width,height:this.state.height,data:this.state.data,margin:{top:0,right:this.state.width/100*10,left:this.state.width/100*10,bottom:this.state.height/100*5}},i.a.createElement(me.a,{strokeDasharray:"3 3"}),i.a.createElement(me.i,{dataKey:"date",height:60,tick:i.a.createElement(he,null)}),i.a.createElement(me.j,null),i.a.createElement(me.h,null),i.a.createElement(me.c,null),i.a.createElement(me.d,{type:"monotone",dataKey:"sum",stroke:"#8884d8",dot:null}),i.a.createElement(me.d,{connectNulls:!0,type:"monotone",dataKey:"goal",stroke:"red",dot:null}))))}}]),t}(n.PureComponent),pe=function(e){function t(){var e,a;Object(l.a)(this,t);for(var n=arguments.length,i=new Array(n),r=0;r<n;r++)i[r]=arguments[r];return(a=Object(c.a)(this,(e=Object(m.a)(t)).call.apply(e,[this].concat(i)))).state={user_id:a.props.user_id,user:a.props.user,userData:a.props.userData,company:a.props.companyData},a}return Object(d.a)(t,e),Object(o.a)(t,[{key:"componentDidMount",value:function(){Object(le.print)("Dashboard","componentDidMount")}},{key:"componentWillUnmount",value:function(){Object(le.print)("Dashboard","componentWillUnmount")}},{key:"shouldComponentUpdate",value:function(e,t){return e.name!==this.state.name||(t.user!==this.state.user||(t.userData!==this.state.userData||t.company!==this.state.company))}},{key:"render",value:function(){return i.a.createElement(ae.a,{container:!0,justify:"space-between",direction:"row",className:"Dashboard"},i.a.createElement(ae.a,{container:!0,justify:"space-around",item:!0,className:"user-wrapper"},i.a.createElement(ce,{user:this.state.user,userData:this.state.userData}),i.a.createElement(de,{sales:this.state.userData.total_sales,goal:this.state.user.monthlyGoal})),i.a.createElement(ie.a,{variant:"middle"}),i.a.createElement(ae.a,{container:!0,justify:"space-around",item:!0,className:"company-wrapper"},i.a.createElement(ue,{companyDates:this.props.companyDates,changeDate:this.props.updateCompany,companyData:this.state.company})))}}]),t}(n.Component),ve=function(){return i.a.createElement("div",{className:"content"},i.a.createElement("p",null,"Error"))},ge=a(356),Ee=a.n(ge),be=(a(816),function(e){function t(){var e,a;Object(l.a)(this,t);for(var n=arguments.length,i=new Array(n),r=0;r<n;r++)i[r]=arguments[r];return(a=Object(c.a)(this,(e=Object(m.a)(t)).call.apply(e,[this].concat(i)))).state={startDate:new Date("foo"),endDate:new Date("foo"),data:[]},a.onChange=a.onChange.bind(Object(y.a)(Object(y.a)(a))),a.convertData=a.convertData.bind(Object(y.a)(Object(y.a)(a))),a.filterData=a.filterData.bind(Object(y.a)(Object(y.a)(a))),a}return Object(d.a)(t,e),Object(o.a)(t,[{key:"componentDidMount",value:function(){this.setState({data:this.props.data})}},{key:"onChange",value:function(e){Object(le.print)("Leaderboards","onChange");var t=e.target.value;switch(e.target.id){case"startDate":this.setState({startDate:new Date(t)});break;case"endDate":this.setState({endDate:new Date(t)})}}},{key:"filterData",value:function(e){var t=this;Object(le.print)("Leaderboards","filterData");var a=[];return a=e.filter(function(e){var a=new Date(e.date);return a>=t.state.startDate&&a<=t.state.endDate?e:a>=t.state.startDate&&"Invalid Date"===t.state.endDate.toString()||a<=t.state.endDate&&"Invalid Date"===t.state.startDate.toString()?e:void 0}),a}},{key:"mapData",value:function(e){Object(le.print)("Leaderboards","mapData");return e.map(function(e){var t=[],a="";for(var n in e)"user_first"===n?a+=e[n]+" ":"user_last"===n?(a+=e[n],t.push(a)):t.push(e[n]);return t})}},{key:"convertData",value:function(e){Object(le.print)("Leaderboards","convertData");var t=[];return t="Invalid Date"!==this.state.startDate.toString()||"Invalid Date"!==this.state.endDate.toString()?this.filterData(e):e,this.mapData(t)}},{key:"render",value:function(){if(Object(le.print)("Leaderboards","render"),this.state.loading)return i.a.createElement("div",{className:"Leaderboards"},i.a.createElement("p",null,"Loading..."));var e=this.state.data,t=this.convertData(e),a=[{name:"Nimi",options:{filter:!0,sort:!1,filterOptions:t.map(function(e){return e[0]})}},{name:"Hit rate %",options:{filter:!1,sort:!0}},{name:"Keskim. myynti",options:{filter:!1,sort:!0}},{name:"Kokonaismyynti",options:{filter:!1,sort:!0}},{name:"Yhteydenotot",options:{filter:!1,sort:!0}},{name:"Tapaamiset",options:{filter:!1,sort:!0}},{name:"Tarjoukset",options:{filter:!1,sort:!0}},{name:"Sopimukset",options:{filter:!1,sort:!0}}];return i.a.createElement("div",{className:"Leaderboards"},i.a.createElement("form",{className:"datePicker"},i.a.createElement(I.a,{className:"date",id:"startDate",label:"Aloitus p\xe4iv\xe4m\xe4\xe4r\xe4",type:"date",InputLabelProps:{shrink:!0},onChange:this.onChange}),i.a.createElement(I.a,{className:"date",id:"endDate",label:"Lopetus p\xe4iv\xe4m\xe4\xe4r\xe4",type:"date",InputLabelProps:{shrink:!0},onChange:this.onChange})),i.a.createElement("div",{id:"table"},i.a.createElement(Ee.a,{title:"Sijoitukset",data:t,columns:a,options:{filterType:"multiselect",selectableRows:!1,search:!1,textLabels:{body:{noMatch:"Ei tuloksia",toolTip:"J\xe4rjest\xe4"},pagination:{next:"Seuraava sivu",previous:"Edellinen sivu",rowsPerPage:"Rivej\xe4 / sivu:",displayRows:"-"},toolbar:{search:"Etsi",downloadCsv:"Lataa CSV",print:"Tulosta",viewColumns:"Sarakkeet",filterTable:"Suodata"},filter:{all:"Kaikki",title:"SUODATTIMET",reset:"RESETOI"},viewColumns:{title:"N\xe4ytetyt Sarakkeet",titleAria:"N\xe4yt\xe4/Piilota Taulukon Sarakkeet"},selectedRows:{text:"rivej\xe4 valittu",delete:"Poista",deleteAria:"Poista Valitut Rivit"}}}})))}}]),t}(n.Component)),ye=(a(818),a(835)),fe=(a(820),function(e){return i.a.createElement("div",{className:"NavItem"},i.a.createElement(ye.a,{className:"linkWrapper",to:e.url,exact:!0},e.icon,i.a.createElement("p",{className:"item"},e.children)))}),Ce=(a(823),function(e){return i.a.createElement("div",{onClick:e.onClick,className:"ActionItem"},e.icon,i.a.createElement("p",{className:"item"},e.children))}),De=a(359),Ne=a.n(De),Oe=a(360),je=a.n(Oe),ke=a(357),Se=a.n(ke),we=a(358),Le=a.n(we),Ie=function(e){return i.a.createElement("div",{className:"Navigation"},i.a.createElement("div",{className:"navigation-wrapper"},i.a.createElement(fe,{url:"/",icon:i.a.createElement(Se.a,null)},"Oma sivu"),i.a.createElement(fe,{url:"/leaderboards",icon:i.a.createElement(Le.a,null)},"Sijoitukset")),i.a.createElement("div",{className:"action-wrapper"},i.a.createElement(Ce,{icon:i.a.createElement(Ne.a,null),onClick:e.handleConfiguration},"Hallinta"),i.a.createElement(Ce,{icon:i.a.createElement(je.a,null),onClick:e.handleLogout},"Kirjaudu ulos")))},Te=(a(825),function(e){function t(){var e,a;Object(l.a)(this,t);for(var n=arguments.length,i=new Array(n),r=0;r<n;r++)i[r]=arguments[r];return(a=Object(c.a)(this,(e=Object(m.a)(t)).call.apply(e,[this].concat(i)))).state={user_id:"",password:""},a}return Object(d.a)(t,e),Object(o.a)(t,[{key:"handleButtonClick",value:function(){Object(le.print)("Login","handleButtonClick"),console.log(this.state.user_id),this.props.onLogin(this.state.user_id)}},{key:"handleInputChange",value:function(e){switch(Object(le.print)("Login","handleInputChange"),e.target.name){case"user_id":this.setState({user_id:e.target.value});break;case"password":this.setState({password:e.target.value})}}},{key:"render",value:function(){return Object(le.print)("Login","render"),i.a.createElement("div",{className:"Login"},i.a.createElement(N.a,{className:"MuiPaper-root-1",elevation:5},i.a.createElement(C.a,{variant:"h5",gutterBottom:!0},"KIRJAUTUMINEN"),i.a.createElement(ie.a,null),i.a.createElement(I.a,{className:"login-item",label:"Ty\xf6ntekij\xe4 id",value:this.state.user_id,onChange:this.handleInputChange.bind(this),margin:"normal",name:"user_id",type:"number"}),i.a.createElement(I.a,{className:"login-item",label:"Salasana",value:this.state.password,onChange:this.handleInputChange.bind(this),name:"password",margin:"normal",type:"password"}),i.a.createElement(x.a,{className:"login-item",size:"medium",disabled:!1,onClick:this.handleButtonClick.bind(this),variant:"contained"},"Submit")))}}]),t}(n.Component)),xe=(a(827),a(30).print),We=a(829).getDate,Ae=function(e){function t(){var e,a;Object(l.a)(this,t);for(var n=arguments.length,i=new Array(n),r=0;r<n;r++)i[r]=arguments[r];return(a=Object(c.a)(this,(e=Object(m.a)(t)).call.apply(e,[this].concat(i)))).state={loggedIn:!1,modalOpen:!1,user_id:"",loadingLeads:!1,loadingLeaderBoards:!1,loadingUser:!1,loadingUserData:!1,loadingCompany:!1,leads:[],leaderBoards:[],user:{},userData:{},companyData:[],startDate:We("monthFirst"),endDate:We("monthLast")},a}return Object(d.a)(t,e),Object(o.a)(t,[{key:"componentDidMount",value:function(){xe("App","componentDidMount"),this.state.loggedIn&&this.updateAll()}},{key:"updateAll",value:function(){this.updateCompanyData(this.state.startDate,this.state.endDate),this.updateLeads(),this.updateLeaderBoards(),this.updateUserData(),this.updateUser()}},{key:"updateCompanyData",value:function(e,t){var a=this,n="/companyChart/get/".concat(e,"/").concat(t);this.setState({loadingCompany:!0,startDate:e,endDate:t},function(){$.get(n).then(function(e){return a.setState({companyData:e.data},function(){a.setState({loadingCompany:!1})})})})}},{key:"updateUserData",value:function(){var e=this,t="/userData/".concat(this.state.user_id);this.setState({loadingUserData:!0},function(){$.get(t).then(function(t){return e.setState({userData:t.data,modalOpen:!1},function(){e.setState({loadingUserData:!1}),xe("App","updateUserData")})}).catch(function(e){return console.log(e)})})}},{key:"updateUser",value:function(){var e=this,t="/users/".concat(this.state.user_id);this.setState({loadingUser:!0},function(){$.get(t).then(function(t){return e.setState({user:t.data},function(){e.setState({loadingUser:!1}),xe("App","updateUser")})}).catch(function(e){return console.log(e)})})}},{key:"updateLeaderBoards",value:function(){var e=this;this.setState({loadingLeaderBoards:!0},function(){$.get("/userData/all").then(function(t){return e.setState({leaderBoards:t.data,modalOpen:!1},function(){e.setState({loadingLeaderBoards:!1}),xe("App","updateLeaderBoards")})})})}},{key:"updateLeads",value:function(){var e=this;this.setState({loadingLeads:!0},function(){$.get("/leads").then(function(t){return e.setState({leads:t.data,modalOpen:!1},function(){e.setState({loadingLeads:!1}),xe("App","updateLeads")})})})}},{key:"handleLogin",value:function(e){var t=this;console.log(e),xe("App","hangleLogin"),this.setState({loggedIn:!0,user_id:e},function(){t.updateAll()})}},{key:"handleLogout",value:function(){xe("App","handleLogout"),this.setState({loggedIn:!1})}},{key:"handleConfiguration",value:function(){xe("App","handleConfiguration")}},{key:"modalClose",value:function(){xe("App","modalClose"),this.setState({modalOpen:!1})}},{key:"modalOpen",value:function(){xe("App","modalOpen"),this.setState({modalOpen:!0})}},{key:"redirect",value:function(){xe("App","redirect"),this.context.router.push("/")}},{key:"render",value:function(){var e=this;return xe("App","render"),this.state.loggedIn?this.state.loadingLeads||this.state.loadingLeaderBoards||this.state.loadingUser||this.state.loadingUserData||this.state.loadingCompany?i.a.createElement("div",{className:"App"},i.a.createElement(Ie,{handleLogout:this.handleLogout.bind(this),handleConfiguration:this.handleConfiguration.bind(this)})):i.a.createElement("div",{className:"App"},i.a.createElement(Ie,{handleLogout:this.handleLogout.bind(this),handleConfiguration:this.handleConfiguration.bind(this)}),i.a.createElement(u.a,null,i.a.createElement(p.a,{path:"/",render:function(){return i.a.createElement(pe,{user:e.state.user,userData:e.state.userData,companyData:e.state.companyData,companyDates:[e.state.startDate,e.state.endDate],updateCompany:e.updateCompanyData.bind(e),user_id:e.state.user_id})},exact:!0}),i.a.createElement(p.a,{path:"/leaderboards",render:function(){return i.a.createElement(be,{data:e.state.leaderBoards})}}),i.a.createElement(p.a,{component:ve})),i.a.createElement("div",{className:"add-wrapper"},i.a.createElement(g.a,{className:"add-icon",onClick:this.modalOpen.bind(this),size:"large",color:"primary"},i.a.createElement(b.a,null))),i.a.createElement(ee.a,{open:this.state.modalOpen,onClose:this.modalClose.bind(this),className:"modal-wrapper",onEscapeKeyDown:this.modalClose.bind(this)},i.a.createElement(Q,{updateUserData:this.updateUserData.bind(this),updateLeaderBoards:this.updateLeaderBoards.bind(this),updateLeads:this.updateLeads.bind(this),updateCompanyGraph:this.updateCompanyData.bind(this),userId:this.state.user_id,closeModal:this.modalClose.bind(this),leads:this.state.leads}))):i.a.createElement("div",null,i.a.createElement(h.a,{to:"/"}),i.a.createElement(Te,{onLogin:this.handleLogin.bind(this)}))}}]),t}(n.Component);Boolean("localhost"===window.location.hostname||"[::1]"===window.location.hostname||window.location.hostname.match(/^127(?:\.(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)){3}$/));var Ue=a(832);s.a.render(i.a.createElement(Ue.a,null,i.a.createElement(Ae,null)),document.getElementById("root")),"serviceWorker"in navigator&&navigator.serviceWorker.ready.then(function(e){e.unregister()})}},[[381,2,1]]]);
//# sourceMappingURL=main.f4415674.chunk.js.map